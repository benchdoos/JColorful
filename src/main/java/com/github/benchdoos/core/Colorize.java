package com.github.benchdoos.core;

import com.github.benchdoos.beans.Theme;
import com.github.benchdoos.beans.components.JTextComponentElement;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class Colorize {
    private Theme theme;

    public Colorize(Theme theme) {
        if (theme == null) {
            throw new IllegalArgumentException("Colorize theme can not be null");
        }
        this.theme = theme;
    }

    public void colorize(Component component) {
        /*System.out.println("> " + String.format("#%02x%02x%02x",
                color.getRed(), color.getGreen(), color.getBlue()));*/
        component.setBackground(theme.getCommonComponent().getBackgroundColor());
        component.setForeground(theme.getCommonComponent().getForegroundColor());

        if (component instanceof JTextComponent) {
            JTextComponent textComponent = (JTextComponent) component;

            final JTextComponentElement componentElement = theme.getTextComponentElement();
            if (componentElement != null) {
                textComponent.setBackground(componentElement.getBackgroundColor());
                textComponent.setForeground(componentElement.getForegroundColor());
                textComponent.setCaretColor(componentElement.getCaretColor());
            }
        }

        if (component instanceof JCheckBox) {
            UIManager.put("CheckBox.focus",Color.RED);
        }

        if (component instanceof JTabbedPane) {
            JTabbedPane pane = (JTabbedPane) component;
            for (int i = 0; i < pane.getTabCount(); i++) {
                try {
                    final Color bg = theme.getTabbedPaneElement().getTabBackgroundColor();
                    System.out.println("Tab: " + theme.getTabbedPaneElement());

                    final Color fg = theme.getTabbedPaneElement().getTabForegroundColor();
                    pane.setBackgroundAt(i, bg);
                    pane.setForegroundAt(i, fg);
                    pane.setBackground(theme.getTabbedPaneElement().getActiveTabBackgroundColor());
                    pane.setForeground(theme.getTabbedPaneElement().getActiveTabForegroundColor());
                } catch (Exception e) {
                    /*NOP*/
                }
            }
        }

    }
}
