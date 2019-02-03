package com.github.benchdoos.beans;

import com.github.benchdoos.beans.components.*;

public interface Theme {

    String getAuthor();

    JTableElement getTableElement();

    void setAuthor(String author);

    BinaryElement getCommonComponent();

    String getName();

    void setName(String name);

    JTextComponentElement getTextComponentElement();

    JTabbedPaneElement getTabbedPaneElement();

    BinaryElement getButtonElement();

    JProgressBarElement getProgressBarElement();

    int getVersion();

    void setVersion(int version);
}
