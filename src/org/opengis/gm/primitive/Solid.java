/*
 * Copyright (C) 2003 Open GIS Consortium, Inc. All Rights Reserved. http://www.opengis.org/Legal/
 */
package org.opengis.gm.primitive;


/**
 * Basis for 3-dimensional geometry. The extent of a solid is
 * defined by the boundary surfaces.
 *
 * @UML type GM_Solid
 * @author ISO/DIS 19107
 * @author <A HREF="http://www.opengis.org">OpenGIS&reg; consortium</A>
 * @version 2.0
 *
 * @see SolidBoundary#toSolid
 *
 * @revisit Some associations are commented out for now.
 */
public interface Solid extends Primitive {
    /**
     * Returns a sequence of sets of {@link Surface}s that limit the extent of this <code>Solid</code>.
     * These surfaces shall be organized into one set of surfaces for each boundary component of the
     * <code>Solid</code>. Each of these shells shall be a cycle (closed composite surface without
     * boundary).
     *
     * <blockquote><font size=2>
     * <strong>NOTE:</strong> The exterior shell of a solid is defined only because the embedding
     * coordinate space is always a 3D Euclidean one. In general, a solid in a bounded 3-dimensional
     * manifold has no distinguished exterior boundary. In cases where "exterior" boundary is not
     * well defined, all the shells of the {@link SolidBoundary} shall be listed as "interior".
     * </font></blockquote>
     *
     * The {@link OrientableSurface}s that bound a solid shall be oriented outward � that is, the
     * "top" of each {@link Surface} as defined by its orientation shall face away from the interior
     * of the solid. Each {@link Shell}, when viewed as a composite surface, shall be a cycle.
     *
     * @return The sets of positions on the boundary.
     * @UML operation boundary
     */
    public SolidBoundary getBoundary();

    /**
     * Returns the sum of the surface areas of all of the boundary components of a solid.
     *
     * @return The area of this solid.
     * @UML operation area
     *
     * @revisit In UML diagram, this operation has an <code>Area</code> return type.
     */
    public double getArea();

    /**
     * Returns the volume of this solid. This is the volume interior to the exterior
     * boundary shell minus the sum of the volumes interior to any interior boundary
     * shell.
     *
     * @return The volume of this solid.
     * @UML operation volume
     *
     * @revisit In UML diagram, this operation has a <code>Volume</code> return type.
     */
    public double getVolume();
    
//    public org.opengis.spatialschema.geometry.complex.GM_CompositeSolid composite[];
//    public void setComposite(org.opengis.spatialschema.geometry.complex.GM_CompositeSolid composite[]) {  }
//    public org.opengis.spatialschema.geometry.complex.GM_CompositeSolid[] getComposite() { return null; }
}
