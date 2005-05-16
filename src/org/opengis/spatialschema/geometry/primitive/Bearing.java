/*$************************************************************************************************
 **
 ** $Id$
 **
 ** $Source$
 **
 ** Copyright (C) 2003-2005 Open GIS Consortium, Inc.
 ** All Rights Reserved. http://www.opengis.org/legal/
 **
 *************************************************************************************************/
package org.opengis.spatialschema.geometry.primitive;

// Annotations
import org.opengis.annotation.UML;
import static org.opengis.annotation.Obligation.*;
import static org.opengis.annotation.Specification.*;


/**
 * Represents direction in the coordinate reference system. In a 2D coordinate reference
 * system, this can be accomplished using a "angle measured from true north" or a 2D vector
 * point in that direction. In a 3D coordinate reference system, two angles or any 3D vector
 * is possible. If both a set of angles and a vector are given, then they shall be consistent
 * with one another.
 *
 * @author ISO/DIS 19107
 * @author <A HREF="http://www.opengis.org">OpenGIS&reg; consortium</A>
 * @version <A HREF="http://www.opengis.org/docs/01-101.pdf">Abstract specification 5</A>
 * @since GeoAPI 1.0
 */
@UML(identifier="Bearing", specification=ISO_19107)
public interface Bearing {
    /**
     * Returns the azimuth and (optionnaly) the altitude.
     * In this variant of bearing usually used for 2D coordinate systems, the first angle (azimuth)
     * is measured from the first coordinate axis (usually north) in a counterclockwise fashion
     * parallel to the reference surface tangent plane. If two angles are given, the second angle
     * (altitude) usually represents the angle above (for positive angles) or below (for negative
     * angles) a local plane parallel to the tangent plane of the reference surface.
     *
     * @return An array of length 0, 1 or 2 containing the azimuth and altitude angles.
     *
     * @revisit Should we split this method in <code>getAzimuth()</code> and
     *          <code>getAltitude()</code> methods instead? Should we provides
     *          a <code>getDimension()</code> method too?
     */
    @UML(identifier="angle", obligation=MANDATORY, specification=ISO_19107)
    public double[] getAngles();

    /**
     * Returns the direction as a vector.
     * In this variant of bearing usually used for 3D coordinate systems, the direction is
     * express as an arbitrary vector, in the coordinate system.
     *
     * @return The direction.
     */
    @UML(identifier="direction", obligation=MANDATORY, specification=ISO_19107)
    public double[] getDirection();
}
