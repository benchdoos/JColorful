package com.github.benchdoos.core;

import com.github.benchdoos.beans.Theme;
import com.github.benchdoos.beans.components.JTextComponentElement;

import javax.swing.*;
import javax.swing.table.JTableHeader;
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
                textComponent.setSelectionColor(componentElement.getSelectionColor());
            }
        }


        if (component instanceof JButton) {
            final JButton button = (JButton) component;

            final Color foregroundColor = theme.getButtonElement().getForegroundColor();
            button.setForeground(foregroundColor);
            final Color backgroundColor = theme.getButtonElement().getBackgroundColor();
            button.setBackground(backgroundColor);

            if (foregroundColor != null && backgroundColor != null) {
                button.setContentAreaFilled(false);
                button.setOpaque(true);
            }
        }

        if (component instanceof JCheckBox) {
            UIManager.put("CheckBox.focus",Color.RED);
            component.repaint();
        }

        if (component instanceof JTabbedPane) {
            JTabbedPane pane = (JTabbedPane) component;
            for (int i = 0; i < pane.getTabCount(); i++) {
                try {
                    final Color bg = theme.getTabbedPaneElement().getTab().getBackgroundColor();
                    System.out.println("Tab: " + theme.getTabbedPaneElement());

                    final Color fg = theme.getTabbedPaneElement().getTab().getForegroundColor();
                    pane.setOpaque(false);
                    pane.setBackgroundAt(i, bg);
                    pane.setForegroundAt(i, fg);
                    pane.setBackground(theme.getTabbedPaneElement().getActiveTab().getBackgroundColor());
                    pane.setForeground(theme.getTabbedPaneElement().getActiveTab().getForegroundColor());
                    UIManager.put("TabbedPane.selected", theme.getTabbedPaneElement().getActiveTab().getBackgroundColor());
                } catch (Exception e) {
                    /*NOP*/
                }
            }
        }

        if (component instanceof JTable) {
            final JTable table = (JTable) component;
            JTableHeader header = table.getTableHeader();
            header.setOpaque(false);//remove look and feel
            header.setBackground(theme.getTableElement().getHeader().getBackgroundColor());
            header.setForeground(theme.getTableElement().getHeader().getForegroundColor());

            table.setSelectionBackground(theme.getTableElement().getSelectedRow().getBackgroundColor());
            table.setSelectionForeground(theme.getTableElement().getSelectedRow().getForegroundColor());

            table.setBackground(theme.getTableElement().getRow().getBackgroundColor());
            table.setForeground(theme.getTableElement().getRow().getForegroundColor());
            //todo add cell background color setting
        }

    }
}
