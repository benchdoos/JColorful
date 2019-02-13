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

    int getVersion();

    void setVersion(int version);


}
