package com.github.benchdoos.jcolorful.core;

import com.github.benchdoos.jcolorful.beans.Theme;

import java.awt.*;

public interface Atomizer {
    void colorize(Component component);

    void colorizeGlobal();

    Theme getTheme();
}
