package com.github.benchdoos.beans;

import com.github.benchdoos.beans.components.*;

public interface Theme {

    String getAuthor();

    void setAuthor(String author);

    BinaryElement getButtonElement();

    BinaryElement getCheckBoxElement();

    JComboBoxElement getComboBoxElement();

    BinaryElement getCommonComponent();

    JListElement getListElement();

    String getName();

    void setName(String name);

    JProgressBarElement getProgressBarElement();

    BinaryElement getRadioButtonElement();

    JTabbedPaneElement getTabbedPaneElement();

    JTableElement getTableElement();

    JTextComponentElement getTextComponentElement();

    JTreeElement getTreeElement();

    int getVersion();

    void setVersion(int version);

    /**
     * Inits default colors, should used once and saved somewhere.
     * Should create theme for default colors.
     *
     * @return Theme with default values if not UIManager used before.
     */
    Theme initDefaults();


}
