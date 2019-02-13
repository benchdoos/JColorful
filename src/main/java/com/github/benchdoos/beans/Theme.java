package com.github.benchdoos.beans;

import com.github.benchdoos.beans.components.*;

public interface Theme {

    String getAuthor();

    void setAuthor(String author);

    BinaryElement getButtonElement();

    BinaryElement getCommonComponent();

    BinaryElement getCheckBoxElement();

    BinaryElement getRadioButtonElement();

    String getName();

    void setName(String name);

    JProgressBarElement getProgressBarElement();

    JTabbedPaneElement getTabbedPaneElement();

    JTableElement getTableElement();

    JComboBoxElement getComboBoxElement();

    JTextComponentElement getTextComponentElement();

    int getVersion();

    void setVersion(int version);


}
