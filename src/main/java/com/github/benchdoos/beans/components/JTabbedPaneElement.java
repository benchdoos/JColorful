package com.github.benchdoos.beans.components;

import java.awt.*;

public interface JTabbedPaneElement extends ThemeElement {
    Color getActiveTabBackgroundColor();

    void setActiveTabBackgroundColor(Color decode);

    Color getActiveTabForegroundColor();

    void setActiveTabForegroundColor(Color decode);

    Color getTabBackgroundColor();

    void setTabBackgroundColor(Color color);

    Color getTabForegroundColor();

    void setTabForegroundColor(Color decode);
}
