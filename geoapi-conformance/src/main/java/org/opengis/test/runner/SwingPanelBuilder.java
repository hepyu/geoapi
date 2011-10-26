/*
 *    GeoAPI - Java interfaces for OGC/ISO standards
 *    http://www.geoapi.org
 *
 *    Copyright (C) 2011 Open Geospatial Consortium, Inc.
 *    All Rights Reserved. http://www.opengeospatial.org/ogc/legal
 *
 *    Permission to use, copy, and modify this software and its documentation, with
 *    or without modification, for any purpose and without fee or royalty is hereby
 *    granted, provided that you include the following on ALL copies of the software
 *    and documentation or portions thereof, including modifications, that you make:
 *
 *    1. The full text of this NOTICE in a location viewable to users of the
 *       redistributed or derivative work.
 *    2. Notice of any changes or modifications to the OGC files, including the
 *       date changes were made.
 *
 *    THIS SOFTWARE AND DOCUMENTATION IS PROVIDED "AS IS," AND COPYRIGHT HOLDERS MAKE
 *    NO REPRESENTATIONS OR WARRANTIES, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 *    TO, WARRANTIES OF MERCHANTABILITY OR FITNESS FOR ANY PARTICULAR PURPOSE OR THAT
 *    THE USE OF THE SOFTWARE OR DOCUMENTATION WILL NOT INFRINGE ANY THIRD PARTY
 *    PATENTS, COPYRIGHTS, TRADEMARKS OR OTHER RIGHTS.
 *
 *    COPYRIGHT HOLDERS WILL NOT BE LIABLE FOR ANY DIRECT, INDIRECT, SPECIAL OR
 *    CONSEQUENTIAL DAMAGES ARISING OUT OF ANY USE OF THE SOFTWARE OR DOCUMENTATION.
 *
 *    The name and trademarks of copyright holders may NOT be used in advertising or
 *    publicity pertaining to the software without specific, written prior permission.
 *    Title to copyright in this software and any associated documentation will at all
 *    times remain with copyright holders.
 */
package org.opengis.test.runner;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.BorderFactory;


/**
 * An utility class for building various panels used by {@link SwingFrame} or other components.
 * This class extends {@link GridBagConstraints} only for opportunist reason - do not rely on that.
 *
 * @author  Martin Desruisseaux (Geomatys)
 * @version 3.1
 * @since   3.1
 */
@SuppressWarnings("serial")
final class SwingPanelBuilder extends GridBagConstraints {
    /**
     * Creates a new builder.
     */
    SwingPanelBuilder() {
    }

    /**
     * Creates the panel where to display {@link ImplementationManifest} information.
     */
    JPanel createManifestPane(final JLabel title, final JLabel version, final JLabel vendor,
            final JLabel vendorID, final JLabel url, final JLabel specification,
            final JLabel specVersion, final JLabel specVendor)
    {
        final JPanel panel = new JPanel(new GridBagLayout());
        final JLabel implementsLabel;
        gridx=0; weightx=0; anchor=WEST; insets.left = 12;
        gridy=0; panel.add(createLabel("Title:",     title),    this);
        gridy++; panel.add(createLabel("Version:",   version),  this);
        gridy++; panel.add(createLabel("Vendor:",    vendor),   this);
        gridy++; panel.add(createLabel("Vendor ID:", vendorID), this);
        gridy++; panel.add(createLabel("URL:",       url),      this);
        gridx=1; weightx=1;
        gridy=0; panel.add(title,    this);
        gridy++; panel.add(version,  this);
        gridy++; panel.add(vendor,   this);
        gridy++; panel.add(vendorID, this);
        gridy++; panel.add(url,      this);
        gridx=2; weightx=0;
        gridy=0; panel.add(implementsLabel = createLabel("implements:", specification), this);
        gridx=3; weightx=1;
        gridy=0; panel.add(specification, this);
        gridy++; panel.add(specVersion,   this);
        gridy++; panel.add(specVendor,    this);

        implementsLabel.setFont(implementsLabel.getFont().deriveFont(Font.ITALIC));

        final Border space = BorderFactory.createEmptyBorder(6, 6, 6, 6);
        panel.setBorder(
                BorderFactory.createCompoundBorder(space,
                BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(), space)));
        panel.setOpaque(false);
        return panel;
    }

    /**
     * Creates the panel where to display details about a particular test.
     */
    JPanel createDetailsPane(final JTextArea exception, final JLabel testName, final JButton viewJavadoc,
            final JTable factories)
    {
        final Font monospaced = Font.decode("Monospaced");
        testName.setFont(monospaced);

        final JPanel panel = new JPanel(new GridBagLayout());
        gridy=0; anchor=WEST; fill=BOTH; insets.left = 12;
        gridx=0; weightx=0; panel.add(createLabel("Test method:", testName), this);
        gridx++; weightx=1; panel.add(testName, this);
        gridx++; weightx=0; panel.add(viewJavadoc, this);

        gridy++; gridx=0; gridwidth=3; weightx=1; insets.top = 12;
        panel.add(createScrollPane(factories, "Factories", new Dimension(600, 100)), this);

        gridy++; weighty=1;
        exception.setEnabled (false);
        exception.setEditable(false);
        exception.setFont(monospaced);
        panel.add(createScrollPane(exception, "Error", null), this);
        panel.setOpaque(false);
        return panel;
    }

    /**
     * Creates a new label with the given text. The created label will be a header
     * for the given component.
     */
    private static JLabel createLabel(final String title, final JComponent labelFor) {
        final JLabel label = new JLabel(title);
        label.setLabelFor(labelFor);
        return label;
    }

    /**
     * Creates a transparent scroll pane for the given component with the given title.
     */
    private static JScrollPane createScrollPane(final JComponent component, final String title, final Dimension size) {
        final JScrollPane scroll = new JScrollPane(component);
        scroll.setBorder(BorderFactory.createTitledBorder(title));
        component.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setOpaque(false);
        if (size != null) {
            scroll.setMinimumSize(size);
            scroll.setMaximumSize(size);
            scroll.setPreferredSize(size);
        }
        return scroll;
    }
}
