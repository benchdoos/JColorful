package com.github.benchdoos.managers;

import com.github.benchdoos.beans.Theme;

import javax.swing.*;
import java.awt.*;

public class JTabbedPaneManager implements Manager {
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
                    /*NOP*/
                }
            }
            try {
                tabbedPane.setBackground(theme.getTabbedPaneElement().getActiveTab().getBackgroundColor());
                tabbedPane.setForeground(theme.getTabbedPaneElement().getActiveTab().getForegroundColor());
            } catch (Exception e) {
                /*NOP*/
            }
        }
    }
}
