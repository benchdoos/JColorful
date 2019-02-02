package com.github.benchdoos.beans.components;

public class JTabbedPaneElementImpl implements JTabbedPaneElement {
    private BinaryElement tab;
    private BinaryElement activeTab;

    public BinaryElement getActiveTab() {
        return activeTab;
    }

    public void setActiveTab(BinaryElement activeTab) {
        this.activeTab = activeTab;
    }

    @Override
    public BinaryElement getTab() {
        return tab;
    }

    @Override
    public void setTab(BinaryElement tab) {
        this.tab = tab;
    }

    @Override
    public String toString() {
        return "JTabbedPaneElementImpl{" +
                "tab=" + tab +
                ", activeTab=" + activeTab +
                '}';
    }
}
