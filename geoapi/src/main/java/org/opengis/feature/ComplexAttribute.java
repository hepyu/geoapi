package org.opengis.feature;

import java.util.Collection;
import java.util.List;

import org.opengis.feature.type.AttributeDescriptor;
import org.opengis.feature.type.ComplexType;
import org.opengis.feature.type.Name;
//import org.opengis.feature.type.AttributeType;

/**
 * A complex Atribtue holds a collection of attribute values in a single group.
 * <p>
 * Direct Access:
 * <ul>
 * <li>Collection<Attribute> get() - list of attributes, may be modified
 * <li>List<Attribute> get( AttributeName ) - retrieve attributes matching provided name
 * </ul>
 * Note that the AttributeName name used above can be deterimed by
 * examining the information available from getType().
 * </p>
 * <p>
 * It is recommended practice to formally use an Expression to access the contents
 * of a ComplexAttribute, the Expression implementation will provide a more
 * complete query langage then supported via direct access.  Once again please
 * use the information in getType() to assist in constructing useful Expressions.
 * </p>
 *
 * @author Jody Garnett, Refractions Research, jgarnett@refractions.net
 * @author Gabriel Roldan
 */
public interface ComplexAttribute extends Attribute {
    ComplexType getType();

    /**
     * Indicates the AttirbuteDescriptor for this content.
     * <p>
     * The attribute descriptor formally captures the name and multiplicity
     * and type associated with this attribute.
     * </p>
     * @return Descriptor for this attribute, if it is contained by another ComplexAttribute
     */
    AttributeDescriptor getDescriptor();

    /**
     * Sets the complete contents of this Attribute, that must be valid against
     * the type's schema descriptor.
     *
     * @throws IllegalArgumentException
     */
    void setValue(Collection<Property> values);

    /**
     * Returns the value of the attribute, which is a list of other properties,
     * attributes + associations..
     *
     */
    Collection<Property> getValue();

    /**
     * Convenience method for getting at the attributes contained in this
     * complex attribute.
     */
    Collection<Attribute> attributes();

    /**
     * Convenience method for getting at the associations contained in this
     * complex attribute.
     * @return
     */
    Collection<Association> associations();

    /**
     * Returns the subset of the attributes returned by {@link #get()} which
     * match the specified name.
     *
     * @param name Name of attributes to return.
     *
     * @return List of attributes matching name, empty list if no match.
     */
    List<Property> get(Name name);
}
