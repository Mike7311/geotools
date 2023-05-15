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
import java.util.NoSuchElementException;
import org.geotools.data.FeatureReader;
import org.geotools.data.complex.feature.type.Types;
import org.geotools.feature.ComplexFeatureBuilder;
import org.geotools.feature.SchemaException;
import org.opengis.feature.Feature;
import org.opengis.feature.IllegalAttributeException;
import org.opengis.feature.type.FeatureType;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

/**
 * ForceCoordinateSystemFeatureReader provides a CoordinateReferenceSystem for FeatureTypes.
 *
 * <p>ForceCoordinateSystemFeatureReader is a wrapper used to force GeometryAttributes to a user
 * supplied CoordinateReferenceSystem rather then the default supplied by the DataStore.
 *
 * <p>Example Use:
 *
 * <pre><code>
 * ForceCoordinateSystemFeatureReader reader =
 *     new ForceCoordinateSystemFeatureReader( originalReader, forceCS );
 *
 * CoordinateReferenceSystem originalCS =
 *     originalReader.getFeatureType().getDefaultGeometry().getCoordinateSystem();
 *
 * CoordinateReferenceSystem newCS =
 *     reader.getFeatureType().getDefaultGeometry().getCoordinateSystem();
 *
 * assertEquals( forceCS, newCS );
 * </code></pre>
 *
 * @author jgarnett, Refractions Research, Inc.
 * @author aaime
 * @author $Author: jive $ (last modification)
 * @version $Id$
 */
public class ForceComplexCoordinateSystemFeatureReader
        implements FeatureReader<FeatureType, Feature> {
    protected FeatureReader<FeatureType, Feature> reader;
    protected ComplexFeatureBuilder builder;

    /** Shortcut constructor that can be used if the new schema has already been computed */
    ForceComplexCoordinateSystemFeatureReader(
            FeatureReader<FeatureType, Feature> reader, FeatureType schema) {
        this.reader = reader;
        this.builder = new ComplexFeatureBuilder(schema);
    }

    /** Builds a new ForceCoordinateSystemFeatureReader */
    public ForceComplexCoordinateSystemFeatureReader(
            FeatureReader<FeatureType, Feature> reader, CoordinateReferenceSystem cs)
            throws SchemaException {
        this(reader, cs, false);
    }

    /** Builds a new ForceCoordinateSystemFeatureReader */
    public ForceComplexCoordinateSystemFeatureReader(
            FeatureReader<FeatureType, Feature> reader,
            CoordinateReferenceSystem cs,
            boolean forceOnlyMissing)
            throws SchemaException {
        if (cs == null) {
            throw new NullPointerException("CoordinateSystem required");
        }

        FeatureType type = reader.getFeatureType();
        CoordinateReferenceSystem originalCs = type.getCoordinateReferenceSystem();

        if (!cs.equals(originalCs)) {
            type = Types.transform(type, cs, forceOnlyMissing, false);
        }
        this.builder = new ComplexFeatureBuilder(type);

        this.reader = reader;
    }

    /** @see FeatureReader#getFeatureType() */
    @Override
    public FeatureType getFeatureType() {
        if (reader == null) {
            throw new IllegalStateException("Reader has already been closed");
        }

        if (builder == null) return reader.getFeatureType();

        return builder.getFeatureType();
    }

    /** @see FeatureReader#next() */
    @Override
    public Feature next() throws IOException, IllegalAttributeException, NoSuchElementException {
        if (reader == null) {
            throw new IllegalStateException("Reader has already been closed");
        }

        Feature next = reader.next();
        if (builder == null) return next;

        return ComplexFeatureBuilder.retype(next, builder);
    }

    /** @see FeatureReader#hasNext() */
    @Override
    public boolean hasNext() throws IOException {
        if (reader == null) {
            throw new IllegalStateException("Reader has already been closed");
        }

        return reader.hasNext();
    }

    /** @see FeatureReader#close() */
    @Override
    public void close() throws IOException {
        if (reader == null) {
            throw new IllegalStateException("Reader has already been closed");
        }

        reader.close();
        reader = null;
        builder = null;
    }
}
