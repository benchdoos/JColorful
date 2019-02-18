package com.github.benchdoos.jcolorful.core;

import com.github.benchdoos.jcolorful.beans.Theme;
import com.github.benchdoos.jcolorful.beans.ThemeImpl;
import com.github.benchdoos.jcolorful.utils.Logging;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.Scanner;

/**
 * Main class of the library
 */
public class JColorful {
    private static final Logger log = LogManager.getLogger(Logging.getCurrentClassName());
    //todo add annotations (what components to ignore)
    public static final Theme EXTREMELY_BLACK = getTheme("/presets/extremelyBlack.json");
    public static final Theme DARK_GRAY = getTheme("/presets/darkGray.json"); //for next releases
    private Atomizer atomizer;

    /**
     * Class  {@code JColorful} is the main class of the JColorful library.
     *
     * @author Eugene Zrazhevsky
     * @since 1.0
     */
    public JColorful() {
        log.info("JColorful initializing...");
    }

    /**
     * Class  {@code JColorful} is the main class of the JColorful library.
     *
     * @param theme theme for current implementation
     * @throws IllegalArgumentException if Theme is null
     * @author Eugene Zrazhevsky
     * @since 1.0
     */
    public JColorful(Theme theme) {
        log.info("JColorful initializing...");
        if (theme == null) throw new IllegalArgumentException("Theme can not be null");
        atomizer = new DefaultAtomizer(theme);
        log.info("JColorful was set a Theme: {}", theme);
    }

    public JColorful(Atomizer atomizer) {
        log.info("JColorful initializing...");
        if (atomizer == null) throw new IllegalArgumentException("Atomizer can not be null");
        this.atomizer = atomizer;
        log.info("JColorful was set a Theme: {}", atomizer.getTheme());
    }

    /**
     * Gets {@link Theme} from json
     *
     * @param path path to json
     * @return Theme from json
     * @throws IllegalArgumentException if something is wrong //not it.
     */
    public static Theme getTheme(String path) {
        log.info("Getting theme from path: {}", path);
        Scanner scanner = new Scanner(JColorful.class.getResourceAsStream(path)).useDelimiter("\\A");
        String content = scanner.hasNext() ? scanner.next() : "";
        log.debug("Content for theme is: {}", content.length());
        return new ThemeImpl(content);
    }

    /**
     * Colorizes {@link Component} by settings, that got in {@link Theme}.
     * Method colorize <u>all</u> childes of the component recursively.
     *
     * @param component root component that should be drawn
     */

    public void colorize(Component component) {
        if (component instanceof Container) {
            Container container = (Container) component;
            final Component[] components = container.getComponents();
            for (final Component coloringComponent : components) {
                if (coloringComponent != null) {
                    atomizer.colorize(coloringComponent);
                    colorize(coloringComponent);
                }
            }
        } else {
            if (component != null) {
                atomizer.colorize(component);
            }
        }
    }

    /**
     * Applies theme settings for global parameters.
     * Should be called before component creation.
     * <b>ATTENTION!</b> Applies to whole project (all components).
     */
    public void colorizeGlobal() {
        atomizer.colorizeGlobal();
    }

    /**
     * Colorizes {@link Component} by settings, that got in {@link Theme}.
     * Method colorize <u>only</u> the given component and <u>do not</u> go recursively.
     *
     * @param component root component that should be drawn
     * @throws RuntimeException if {@link Theme }is not set
     */
    public void colorizeSingle(Component component) {
        atomizer.colorize(component);
    }

    /**
     * Gives back {@link Atomizer} that was set
     *
     * @return curr {@link Atomizer}
     */
    public Atomizer getAtomizer() {
        return atomizer;
    }

    /**
     * Sets {@link Atomizer}, that colorizes components
     *
     * @param atomizer to colorize
     */
    public void setAtomizer(Atomizer atomizer) {
        this.atomizer = atomizer;
    }

    /**
     * Gives back {@link Theme} that was set
     *
     * @return current {@link Theme}
     */
    public Theme getTheme() {
        if (atomizer != null) {
            return atomizer.getTheme();
        } else return null;
    }
}
