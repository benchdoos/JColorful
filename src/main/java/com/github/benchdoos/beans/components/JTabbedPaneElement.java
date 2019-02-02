package com.github.benchdoos.beans.components;

public interface JTabbedPaneElement extends ThemeElement {
    BinaryElement getActiveTab();

    void setActiveTab(BinaryElement activeTab);

    BinaryElement getTab();

    void setTab(BinaryElement tab);

}
