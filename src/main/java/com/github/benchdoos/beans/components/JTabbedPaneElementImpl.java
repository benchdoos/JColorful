package com.github.benchdoos.beans.components;

import java.awt.*;

public class JTabbedPaneElementImpl implements JTabbedPaneElement {
    private Color tabBackgroundColor;
    private Color tabForegroundColor;
    private Color activeTabBackgroundColor;
    private Color activeTabForegroundColor;

    public Color getActiveTabBackgroundColor() {
        return activeTabBackgroundColor;
    }

    public void setActiveTabBackgroundColor(Color activeTabBackgroundColor) {
        this.activeTabBackgroundColor = activeTabBackgroundColor;
    }

    public Color getActiveTabForegroundColor() {
        return activeTabForegroundColor;
    }

    public void setActiveTabForegroundColor(Color activeTabForegroundColor) {
        this.activeTabForegroundColor = activeTabForegroundColor;
    }

    @Override
    public Color getTabBackgroundColor() {
        return tabBackgroundColor;
    }

    @Override
    public void setTabBackgroundColor(Color color) {
        this.tabBackgroundColor = color;
    }

    @Override
    public Color getTabForegroundColor() {
        return tabForegroundColor;
    }

    @Override
    public void setTabForegroundColor(Color tabForegroundColor) {
        this.tabForegroundColor = tabForegroundColor;
    }

    @Override
    public String toString() {
        return "JTabbedPaneElementImpl{" + "tabBackgroundColor=" + tabBackgroundColor +
                ", tabForegroundColor=" + tabForegroundColor +
                ", activeTabBackgroundColor=" + activeTabBackgroundColor +
                ", activeTabForegroundColor=" + activeTabForegroundColor +
                '}';
    }
}
