/*$************************************************************************************************
 **
 ** $Id$
 **
 ** $URL$
 **
 ** Copyright (C) 2003-2005 Open GIS Consortium, Inc.
 ** All Rights Reserved. http://www.opengis.org/legal/
 **
 *************************************************************************************************/
package org.opengis.filter.sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.opengis.annotation.UML;
import org.opengis.coverage.grid.SequenceType;
import org.opengis.util.CodeList;

import static org.opengis.annotation.Obligation.CONDITIONAL;
import static org.opengis.annotation.Specification.OGC_02059;


/**
 * Captures the {@link SortBy} order, {@code ASC} or {@code DESC}.
 *
 * @see <a href="http://schemas.opengis.net/filter/1.1.0/sort.xsd">
 * @author Jody Garnett (Refractions Research)
 * @since GeoAPI 2.1
 */
public final class SortOrder extends CodeList<SortOrder> {
    /**
     * Serial number for compatibility with different versions.
     */
    private static final long serialVersionUID = 7840334200112859571L;

    /**
     * The list of enumeration available in this virtual machine.
     * <strong>Must be declared first!</strong>.
     */
    private static final List<SortOrder> VALUES = new ArrayList<SortOrder>(2);

    /**
     * Represents acending order.
     * <p>
     * Note this has the string representation of {@code "ASC"} to agree
     * with the Filter 1.1 specification.
     * </p>
     */
    @UML(identifier="ASC", obligation=CONDITIONAL, specification=OGC_02059)
    public static final SortOrder ASCENDING  = new SortOrder("ASCENDING", "ASC");

    /**
     * Represents descending order.
     * <p>
     * Note this has the string representation of {@code "DESC"} to agree
     * with the Filter 1.1 specification.
     * </p>
     */
    @UML(identifier="DESC", obligation=CONDITIONAL, specification=OGC_02059)
    public static final SortOrder DESCENDING = new SortOrder("DESCENDING", "DESC");

    /**
     * The SQL keyword for this sorting order.
     */
    private final String sqlKeyword;

    /**
     * Constructs an enum with the given name. The new enum is
     * automatically added to the list returned by {@link #values}.
     *
     * @param name The enum name. This name must not be in use by an other enum of this type.
     * @param sqlKeyword The SQL keyword for this sorting order.
     */
    private SortOrder(final String name, final String sqlKeyword) {
        super(name, VALUES);
        this.sqlKeyword = sqlKeyword;
    }

    /**
     * Returns the element name for this sorting order as a SQL {@code "ASC"}
     * or {@code "DESC"} keyword.
     * <p>
     * We have chosen to use the full names {@link #ASCENDING} and
     * {@link #DESCENDING} for our code list. The original XML schema
     * matches the SQL convention of {@code ASC} and {@code DESC}.
     */
    public String toSQL() {
        return sqlKeyword;
    }

    /**
     * Returns the list of {@code SortOrder}s.
     */
    public static SortOrder[] values() {
        synchronized (VALUES) {
            return (SortOrder[]) VALUES.toArray(new SortOrder[VALUES.size()]);
        }
    }

    /**
     * Returns the list of enumerations of the same kind than this enum.
     */
    public /*{SortOrder}*/ CodeList[] family() {
        return values();
    }

    /**
     * Returns the SortOrder that matches the given string, or returns a
     * new one if none match it.
     */
    public static SortOrder valueOf(String code) {
        if (code == null) {
            return null;
        }
        synchronized (VALUES) {
            Iterator iter = VALUES.iterator();
            while (iter.hasNext()) {
                SortOrder type = (SortOrder) iter.next();
                if (code.equalsIgnoreCase(type.name())) {
                    return type;
                }
            }
            return new SortOrder(code, code);
        }
    }
}
