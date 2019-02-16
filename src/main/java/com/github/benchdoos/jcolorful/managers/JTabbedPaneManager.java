package com.github.benchdoos.jcolorful.managers;

import com.github.benchdoos.jcolorful.beans.Theme;
import com.github.benchdoos.jcolorful.utils.Logging;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class JTabbedPaneManager implements Manager {
    private static final Logger log = LogManager.getLogger(Logging.getCurrentClassName());
    private Theme theme;

    public JTabbedPaneManager(Theme theme) {

        this.theme = theme;
    }

    @Override
    public void paintComponent(Component component) {
        if (component instanceof JTabbedPane) {
            JTabbedPane tabbedPane = (JTabbedPane) component;
            for (int i = 0; i < tabbedPane.getTabCount(); i++) {
                try {
                    final Color bg = theme.getTabbedPaneElement().getTab().getBackgroundColor();

                    final Color fg = theme.getTabbedPaneElement().getTab().getForegroundColor();
                    tabbedPane.setOpaque(false);
                    tabbedPane.setBackgroundAt(i, bg);
                    tabbedPane.setForegroundAt(i, fg);
                } catch (Exception e) {
                    log.warn("Could not get colors for JTabbedPaneElement", e);

                }
            }
        }
    }
}
