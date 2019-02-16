package com.github.benchdoos.jcolorful.beans;

import com.github.benchdoos.jcolorful.beans.components.*;

public interface Theme {

    /**
     * Returns information about author
     *
     * @return author info.
     */
    String getAuthor();

    /**
     * Setter for author
     * @param author to set
     */
    void setAuthor(String author);

    /**
     * Getter for {@link javax.swing.JButton}
     * @return BinaryElement for {@link javax.swing.JButton}
     */
    BinaryElement getButtonElement();

    /**
     * Getter for {@link javax.swing.JCheckBox}
     * @return BinaryElement for {@link javax.swing.JCheckBox}
     */
    BinaryElement getCheckBoxElement();

    /**
     * Getter for {@link JComboBoxElement}
     * @return JComboBoxElement for  {@link JComboBoxElement}
     */
    JComboBoxElement getComboBoxElement();

    /**
     * Getter for common component
     * @return BinaryElement for common component
     * @since 1.0
     */
    BinaryElement getCommonComponent();

    /**
     * Getter for {@link javax.swing.JList}
     * @return JListElement for {@link javax.swing.JList}
     */
    JListElement getListElement();

    /**
     * Returns information about theme name
     * @return theme name
     */
    String getName();

    /**
     * Setter for theme name
     * @param name of theme
     */
    void setName(String name);

    /**
     * Getter for {@link javax.swing.JProgressBar}
     * @return JProgressBarElement for {@link javax.swing.JProgressBar}
     */
    JProgressBarElement getProgressBarElement();

    /**
     * Getter for {@link javax.swing.JRadioButton}
     * @return BinaryElement for {@link javax.swing.JRadioButton}
     */
    BinaryElement getRadioButtonElement();

    /**
     * Getter for {@link javax.swing.JTabbedPane}
     * @return JTabbedPaneElement for {@link javax.swing.JTabbedPane}
     */
    JTabbedPaneElement getTabbedPaneElement();

    /**
     * Getter for {@link javax.swing.JTable}
     * @return JTableElement for {@link javax.swing.JTable}
     */
    JTableElement getTableElement();

    /**
     * Getter for {@link javax.swing.text.JTextComponent}
     * @return JTextComponentElement for {@link javax.swing.text.JTextComponent}
     */
    JTextComponentElement getTextComponentElement();

    /**
     * Getter for {@link javax.swing.JTree}
     * @return JTableElement for {@link javax.swing.JTree}
     */
    JTreeElement getTreeElement();

    /**
     * Setter for theme version
     * @return version of theme
     */
    int getVersion();

    /**
     * Returns information about theme version
     * @param version of theme
     */
    void setVersion(int version);

    /**
     * Inits default colors, should used once and saved somewhere.
     * Should create theme for default colors.
     *
     * @return Theme with default values if not UIManager used before.
     */
    Theme initDefaults();


}
