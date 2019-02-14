package com.github.benchdoos.core;

import com.github.benchdoos.beans.Theme;
import com.github.benchdoos.beans.ThemeBean;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;

import static java.util.Collections.list;

/**
 * Main class of the library
 */
public class JColorful {
    //todo add annotations (what components to ignore)
    public static final Theme EXTREMELY_BLACK = getTheme("/presets/extremelyBlack.json");
    public static final Theme DARK_GRAY = getTheme("/presets/darkGray.json");

    private Theme theme = null;

    /**
     * Class  {@code JColorful} is the main class of the JColorful library.
     *
     * @author Eugene Zrazhevsky
     * @since 1.0
     */
    public JColorful() {
    }


    /**
     * Class  {@code JColorful} is the main class of the JColorful library.
     *
     * @param theme theme for current implementation
     * @author Eugene Zrazhevsky
     * @since 1.0
     */
    public JColorful(Theme theme) {
        if (theme == null) throw new IllegalArgumentException("Theme bean can not be null");
        this.theme = theme;
        System.out.println("JColorful was set a Theme:"
                + " name: " + theme.getName()
                + "; by: " + theme.getAuthor()
                + "; version: " + theme.getVersion());
    }

    public static void printUIManagerKeys() {
        UIDefaults defaults = UIManager.getDefaults();
        Enumeration<Object> keysEnumeration = defaults.keys();
        ArrayList<Object> keysList = list(keysEnumeration);
        for (Object key : keysList) {
            System.out.println("UIManager: " + key + " - " + UIManager.get(key));
        }
    }

    /**
     * Colorizes {@link Component} by settings, that got in {@link Theme}.
     * Method colorize <u>all</u> childes of the component recursively.
     *
     * @param component root component that should be drawn
     */

    public void colorize(Component component) {
        if (theme == null) throw new RuntimeException("Theme should be set.");

        if (component instanceof Container) {
            Container container = (Container) component;
            final Component[] components = container.getComponents();
            for (final Component coloringComponent : components) {
                if (coloringComponent != null) {
                    new Atomizer(theme).colorize(coloringComponent);
                    colorize(coloringComponent);
                }
            }
        } else {
            new Atomizer(theme).colorize(component);
        }
    }

    /**
     * Applies theme settings for global parameters.
     * Should be called before component creation.
     * <b>ATTENTION!</b> Applies to whole project (all components).
     */
    public void colorizeGlobal() {
        new Atomizer(theme).colorizeGlobal();
    }

    /**
     * Colorizes {@link Component} by settings, that got in {@link Theme}.
     * Method colorize <u>only</u> the given component and <u>do not</u> go recursively.
     *
     * @param component root component that should be drawn
     * @throws RuntimeException if {@link Theme }is not set
     */
    public void colorizeSingle(Component component) {
        if (theme == null) throw new RuntimeException("Theme should be set.");

        new Atomizer(theme).colorize(component);
    }

    /**
     * Gives back {@link Theme} that was set
     *
     * @return current {@link Theme}
     */
    public Theme getTheme() {
        return theme;
    }

    /**
     * Setter for {@link Theme}
     *
     * @param theme to set for {@code JColorful}
     * @return {@link JColorful} itself
     * @throws IllegalArgumentException if {@link Theme} is not set.
     */
    public JColorful setTheme(ThemeBean theme) {
        if (theme == null) throw new IllegalArgumentException("Theme bean can not be null");
        this.theme = theme;

        return this;
    }

    /**
     * Gets {@link Theme} from json
     *
     * @param path path to json
     * @return Theme from json
     * @throws IllegalArgumentException if something is wrong //not it.
     */
    public static Theme getTheme(String path) {
        Scanner scanner = new Scanner(JColorful.class.getResourceAsStream(path)).useDelimiter("\\A");
        String content = scanner.hasNext() ? scanner.next() : "";
        return new ThemeBean(content);
    }
}
