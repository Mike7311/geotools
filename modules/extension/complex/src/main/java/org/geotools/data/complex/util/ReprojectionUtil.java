package org.geotools.data.complex.util;

import java.io.IOException;
import org.geotools.data.FeatureReader;
import org.geotools.data.Query;
import org.geotools.data.complex.crs.ForceComplexCoordinateSystemFeatureReader;
import org.geotools.data.complex.crs.ReprojectComplexFeatureReader;
import org.geotools.feature.FeatureTypes;
import org.geotools.feature.SchemaException;
import org.opengis.feature.Feature;
import org.opengis.feature.type.FeatureType;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

public class ReprojectionUtil {

    private ReprojectionUtil() {}

    public static FeatureReader<FeatureType, Feature> reprojectComplex(
            Query query, FeatureReader<FeatureType, Feature> reader) throws IOException {
        CoordinateReferenceSystem sourceCRS = query.getCoordinateSystem();
        CoordinateReferenceSystem targetCRS = query.getCoordinateSystemReproject();
        CoordinateReferenceSystem nativeCRS =
                reader.getFeatureType().getCoordinateReferenceSystem();

        if (sourceCRS != null && !sourceCRS.equals(nativeCRS)) {
            // override the nativeCRS
            try {
                reader = new ForceComplexCoordinateSystemFeatureReader(reader, sourceCRS);
            } catch (SchemaException e) {
                throw (IOException)
                        new IOException("Error occurred trying to force CRS").initCause(e);
            }
        } else {
            // no override
            sourceCRS = nativeCRS;
        }
        if (targetCRS != null) {
            if (sourceCRS == null) {
                throw new IOException("Cannot reproject data, the source CRS is not available");
            } else if (FeatureTypes.shouldReproject(reader.getFeatureType(), targetCRS)) {
                try {
                    reader = new ReprojectComplexFeatureReader(reader, targetCRS);
                } catch (Exception e) {
                    if (e instanceof IOException) throw (IOException) e;
                    else
                        throw (IOException)
                                new IOException("Error occurred trying to reproject data")
                                        .initCause(e);
                }
            }
        }
        return reader;
    }
}
