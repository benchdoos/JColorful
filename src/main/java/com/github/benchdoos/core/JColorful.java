package com.github.benchdoos.core;

import com.github.benchdoos.beans.Theme;
import com.github.benchdoos.beans.ThemeBean;

import java.awt.*;

public class JColorful {
    private Theme themeBean = null;

    public JColorful() {
    }

    public JColorful(Theme themeBean) {
        if (themeBean == null) throw new IllegalArgumentException("Theme bean can not be null");
        this.themeBean = themeBean;
        System.out.println("JColorful was set a Theme:"
                + " name: " + themeBean.getName()
                + "; by: " + themeBean.getAuthor()
                + "; version: " + themeBean.getVersion());
    }

    public void colorize(Component component) {
        if (component instanceof Container) {
            Container container = (Container) component;
            final Component[] components = container.getComponents();
            for (final Component coloringComponent : components) {
                if (coloringComponent != null) {
                    new Atomizer(themeBean).colorize(coloringComponent);
                    colorize(coloringComponent);
                }
            }
        } else {
            new Atomizer(themeBean).colorize(component);
        }

    }

    public Theme getThemeBean() {
        return themeBean;
    }

    public JColorful setThemeBean(ThemeBean themeBean) {
        this.themeBean = themeBean;

        return this;
    }
}
