/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2003-2008, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.data.complex.crs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.geotools.data.DataSourceException;
import org.geotools.data.DelegatingFeatureReader;
import org.geotools.data.FeatureReader;
import org.geotools.data.complex.feature.type.Types;
import org.geotools.feature.ComplexFeatureBuilder;
import org.geotools.feature.SchemaException;
import org.geotools.geometry.jts.GeometryCoordinateSequenceTransformer;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.locationtech.jts.geom.Geometry;
import org.opengis.feature.Feature;
import org.opengis.feature.IllegalAttributeException;
import org.opengis.feature.Property;
import org.opengis.feature.type.FeatureType;
import org.opengis.feature.type.GeometryDescriptor;
import org.opengis.feature.type.Name;
import org.opengis.feature.type.PropertyDescriptor;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.OperationNotFoundException;
import org.opengis.referencing.operation.TransformException;

/**
 * ReprojectFeatureReader provides a reprojection for FeatureTypes.
 *
 * <p>ReprojectFeatureReader is a wrapper used to reproject GeometryAttributes to a user supplied
 * CoordinateReferenceSystem from the original CoordinateReferenceSystem supplied by the original
 * FeatureReader.
 *
 * <p>Example Use:
 *
 * <pre><code>
 * ReprojectFeatureReader reader =
 *     new ReprojectFeatureReader( originalReader, reprojectCS );
 *
 * CoordinateReferenceSystem originalCS =
 *     originalReader.getFeatureType().getDefaultGeometry().getCoordinateSystem();
 *
 * CoordinateReferenceSystem newCS =
 *     reader.getFeatureType().getDefaultGeometry().getCoordinateSystem();
 *
 * assertEquals( reprojectCS, newCS );
 * </code></pre>
 *
 * TODO: handle the case where there is more than one geometry and the other geometries have a
 * different CS than the default geometry
 *
 * @author jgarnett, Refractions Research, Inc.
 * @author aaime
 * @author $Author: jive $ (last modification)
 * @version $Id$
 */
public class ReprojectComplexFeatureReader
        implements DelegatingFeatureReader<FeatureType, Feature> {

    FeatureReader<FeatureType, Feature> reader;
    FeatureType originalType;
    FeatureType schema;
    GeometryCoordinateSequenceTransformer transformer;
    Map<Name, GeometryCoordinateSequenceTransformer> transformers;

    /**
     * Direct constructor reprojecting the provided reader into the schema indicated (using the
     * supplied math transformation).
     *
     * <p>Please note schema is that of the expected results, You may need to use
     * FeatureTypes.transform( FeatureType, crs ) to create the schema provider.
     *
     * @param reader original reader with results in the original coordinate reference system
     * @param schema This is the target schema describing the results in the expected coordinate
     *     reference system
     * @param transform the math transform used to go from reader coordinate reference system to the
     *     provided schema coordinate reference system
     */
    public ReprojectComplexFeatureReader(
            FeatureReader<FeatureType, Feature> reader,
            FeatureType schema,
            MathTransform transform) {
        this.reader = reader;
        this.schema = schema;
        this.transformer = new GeometryCoordinateSequenceTransformer();
        transformer.setMathTransform(transform);
    }

    /**
     * Constructor that will generate schema and mathTransforms for the results.
     *
     * @param reader original reader
     * @param cs Target coordinate reference system; will be used to create the target FeatureType
     *     and MathTransforms used to transform the data
     */
    public ReprojectComplexFeatureReader(
            FeatureReader<FeatureType, Feature> reader, CoordinateReferenceSystem cs)
            throws SchemaException, OperationNotFoundException, NoSuchElementException,
                    FactoryException {
        this(reader, Types.transform(reader.getFeatureType(), cs, false, true));
    }

    /**
     * Constructor that will generate mathTransforms for the results, based on target schema.
     *
     * @param reader original reader
     * @param schema Target schema; will be used to create the target MathTransforms used to
     *     transform the data
     */
    public ReprojectComplexFeatureReader(
            FeatureReader<FeatureType, Feature> reader, FeatureType schema)
            throws SchemaException, OperationNotFoundException, NoSuchElementException,
                    FactoryException {
        this.originalType = reader.getFeatureType();
        this.schema = schema;
        this.reader = reader;
        this.transformers = new HashMap<>();
        for (PropertyDescriptor descriptor : originalType.getDescriptors()) {
            if (descriptor instanceof GeometryDescriptor) {
                GeometryDescriptor descr = (GeometryDescriptor) descriptor;
                CoordinateReferenceSystem original = descr.getCoordinateReferenceSystem();
                CoordinateReferenceSystem target =
                        ((GeometryDescriptor) schema.getDescriptor(descr.getName()))
                                .getCoordinateReferenceSystem();
                if (!CRS.equalsIgnoreMetadata(original, target)) {
                    GeometryCoordinateSequenceTransformer transformer =
                            new GeometryCoordinateSequenceTransformer();
                    transformer.setMathTransform(CRS.findMathTransform(original, target, true));
                    transformers.put(descriptor.getName(), transformer);
                }
            }
        }

        if (transformers.isEmpty()) {
            throw new IllegalArgumentException(
                    "Nothing to be reprojected! (check before using wrapper)");
        }
    }

    protected GeometryCoordinateSequenceTransformer getTransformer(Name attributeName) {
        if (transformer != null) {
            return transformer;
        } else {
            return transformers.get(attributeName);
        }
    }

    @Override
    public FeatureReader<FeatureType, Feature> getDelegate() {
        return reader;
    }

    /**
     * Implement getFeatureType.
     *
     * <p>Description ...
     *
     * @see FeatureReader#getFeatureType()
     */
    @Override
    public FeatureType getFeatureType() {
        if (schema == null) {
            throw new IllegalStateException("Reader has already been closed");
        }

        return schema;
    }

    /**
     * Implement next.
     *
     * <p>Description ...
     *
     * @see FeatureReader#next()
     */
    @Override
    public Feature next() throws IOException, IllegalAttributeException, NoSuchElementException {
        if (reader == null) {
            throw new IllegalStateException("Reader has already been closed");
        }

        Feature next = reader.next();

        try {
            for (PropertyDescriptor descriptor : schema.getDescriptors()) {
                Name name = descriptor.getName();
                Property property = next.getProperty(name);
                Object propertyValue = property.getValue();
                if (descriptor instanceof GeometryDescriptor && propertyValue instanceof Geometry) {
                    GeometryDescriptor descr =
                            (GeometryDescriptor) originalType.getDescriptor(name);
                    GeometryCoordinateSequenceTransformer transformer =
                            getTransformer(descr.getName());
                    if (transformer != null) {
                        property.setValue(transformer.transform((Geometry) propertyValue));
                        JTS.setCRS(
                                (Geometry) propertyValue,
                                ((GeometryDescriptor) descriptor).getCoordinateReferenceSystem());
                    }
                }
            }
        } catch (TransformException e) {
            throw new DataSourceException(
                    "A transformation exception occurred while reprojecting data on the fly", e);
        }
        // building the new reprojected feature
        ComplexFeatureBuilder complexFeatureBuilder = new ComplexFeatureBuilder(schema);
        for (Property property : next.getProperties()) {
            complexFeatureBuilder.append(property.getName(), property);
        }
        Feature reprojected = complexFeatureBuilder.buildFeature(next.getIdentifier().getID());
        //                ComplexFeatureBuilder.build(schema, attributes, );
        // copying the user data if any
        if (next.hasUserData()) {
            reprojected.getUserData().putAll(next.getUserData());
        }
        return reprojected;
    }

    /**
     * Implement hasNext.
     *
     * <p>Description ...
     *
     * @see FeatureReader#hasNext()
     */
    @Override
    public boolean hasNext() throws IOException {
        if (reader == null) {
            throw new IllegalStateException("Reader has already been closed");
        }

        return reader.hasNext();
    }

    /**
     * Implement close.
     *
     * <p>Description ...
     *
     * @see FeatureReader#close()
     */
    @Override
    public void close() throws IOException {
        if (reader == null) {
            throw new IllegalStateException("Reader has already been closed");
        }

        reader.close();
        reader = null;
        schema = null;
    }
}
