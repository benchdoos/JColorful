package com.github.benchdoos.core;

import com.github.benchdoos.beans.DefaultThemes;
import com.github.benchdoos.beans.JTheme;
import com.github.benchdoos.beans.ThemeBean;

import javax.swing.*;
import java.awt.*;

public class JColorful {
    private JTheme themeBean = null;

    public JColorful() {
    }

    public JTheme getThemeBean() {
        return themeBean;
    }

    public JColorful setThemeBean(ThemeBean themeBean) {
        this.themeBean = themeBean;
        return this;
    }

    public JColorful(JTheme themeBean) {
        if(themeBean==null) throw new IllegalArgumentException("JTheme bean can not be null");

        this.themeBean = themeBean;
    }

    public void colorize(Component component) {
        if (component instanceof Container) {
            Container container = (Container) component;
            final Component[] components = container.getComponents();
            for (final Component coloringComponent : components) {
                if (coloringComponent != null) {
                    new Colorize(themeBean).colorize(coloringComponent);
                    colorize(coloringComponent);
                }
            }
        } else {
            new Colorize(themeBean).colorize(component);
        }

    }
}
