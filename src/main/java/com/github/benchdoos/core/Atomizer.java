package com.github.benchdoos.core;

import com.github.benchdoos.beans.Theme;
import com.github.benchdoos.beans.components.JTextComponentElement;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class Atomizer {
    private Theme theme;

    public Atomizer(Theme theme) {
        if (theme == null) {
            throw new IllegalArgumentException("Atomizer theme can not be null");
        }
        this.theme = theme;
    }

    public void colorize(Component component) {
        /*System.out.println("> " + String.format("#%02x%02x%02x",
                color.getRed(), color.getGreen(), color.getBlue()));*/
        component.setBackground(theme.getCommonComponent().getBackgroundColor());
        component.setForeground(theme.getCommonComponent().getForegroundColor());

        if (component instanceof JTextComponent) {
            paintJTextComponent((JTextComponent) component);
        }

        if (component instanceof JButton) {
            paintJButton((JButton) component);
        }

        if (component instanceof JProgressBar) {
            paintJProgressBar((JProgressBar) component);
        }


        if (component instanceof JCheckBox) {
            UIManager.put("CheckBox.focus", Color.RED);
            component.repaint();
        }

        if (component instanceof JTabbedPane) {
            paintJTabbedPane((JTabbedPane) component);
        }

        if (component instanceof JTable) {
            paintJTable((JTable) component);
        }

    }

    private void paintJProgressBar(JProgressBar component) {
        //found no another way to do this
        if (!component.isIndeterminate()) {
            component.setStringPainted(true);
            component.setOpaque(false);
            component.setBackground(theme.getProgressBarElement().getBackgroundColor());
            component.setForeground(theme.getProgressBarElement().getForegroundColor());
            UIManager.put("ProgressBar.background", theme.getProgressBarElement().getBackgroundColor());
            UIManager.put("ProgressBar.foreground", theme.getProgressBarElement().getForegroundColor());
            UIManager.put("ProgressBar.selectionBackground", theme.getProgressBarElement().getStringElement().getBackgroundColor());
            UIManager.put("ProgressBar.selectionForeground", theme.getProgressBarElement().getStringElement().getForegroundColor());
            SwingUtilities.updateComponentTreeUI(component);
        }
    }

    private void paintJButton(JButton component) {

        final Color foregroundColor = theme.getButtonElement().getForegroundColor();
        component.setForeground(foregroundColor);
        final Color backgroundColor = theme.getButtonElement().getBackgroundColor();
        component.setBackground(backgroundColor);

        if (foregroundColor != null && backgroundColor != null) {
            component.setContentAreaFilled(false);
            component.setOpaque(true);
        }
    }

    private void paintJTabbedPane(JTabbedPane component) {
        for (int i = 0; i < component.getTabCount(); i++) {
            try {
                final Color bg = theme.getTabbedPaneElement().getTab().getBackgroundColor();
                System.out.println("Tab: " + theme.getTabbedPaneElement());

                final Color fg = theme.getTabbedPaneElement().getTab().getForegroundColor();
                component.setOpaque(false);
                component.setBackgroundAt(i, bg);
                component.setForegroundAt(i, fg);
                component.setBackground(theme.getTabbedPaneElement().getActiveTab().getBackgroundColor());
                component.setForeground(theme.getTabbedPaneElement().getActiveTab().getForegroundColor());
                UIManager.put("TabbedPane.selected", theme.getTabbedPaneElement().getActiveTab().getBackgroundColor());
            } catch (Exception e) {
                /*NOP*/
            }
        }
    }

    private void paintJTable(JTable component) {
        JTableHeader header = component.getTableHeader();
        header.setOpaque(false);//remove look and feel
        header.setBackground(theme.getTableElement().getHeader().getBackgroundColor());
        header.setForeground(theme.getTableElement().getHeader().getForegroundColor());

        component.setSelectionBackground(theme.getTableElement().getSelectedRow().getBackgroundColor());
        component.setSelectionForeground(theme.getTableElement().getSelectedRow().getForegroundColor());

        component.setBackground(theme.getTableElement().getRow().getBackgroundColor());
        component.setForeground(theme.getTableElement().getRow().getForegroundColor());
        //todo add cell background color setting
    }

    private void paintJTextComponent(JTextComponent component) {
        final JTextComponentElement componentElement = theme.getTextComponentElement();
        if (componentElement != null) {
            component.setBackground(componentElement.getBackgroundColor());
            component.setForeground(componentElement.getForegroundColor());
            component.setCaretColor(componentElement.getCaretColor());
            component.setSelectionColor(componentElement.getSelectionColor());
        }
    }
}
