package com.github.benchdoos.core;

import com.github.benchdoos.beans.Theme;
import com.github.benchdoos.beans.components.JProgressBarElement;
import com.github.benchdoos.beans.components.JTableElement;
import com.github.benchdoos.beans.components.JTextComponentElement;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.text.JTextComponent;
import java.awt.*;

class Atomizer {
    private Theme theme;

    Atomizer(Theme theme) {
        if (theme == null) {
            throw new IllegalArgumentException("Atomizer theme can not be null");
        }
        this.theme = theme;
    }

    void colorize(Component component) {
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

    void colorizeGlobal() {
        System.out.println("Colorizing global for theme: " + theme);
        colorizeGlobalJTabbedPane();
        colorizeGlobalJProgressBar();
    }

    private void colorizeGlobalJProgressBar() {
        final JProgressBarElement progressBarElement = theme.getProgressBarElement();
        try {
            UIManager.put("ProgressBar.background", progressBarElement.getStringElement().getBackgroundColor()); //does not work
            UIManager.put("ProgressBar.foreground", progressBarElement.getStringElement().getForegroundColor()); //does not work

            UIManager.put("ProgressBar.selectionBackground", new ColorUIResource(progressBarElement.getStringElement().getBackgroundColor()));
            UIManager.put("ProgressBar.selectionForeground", new ColorUIResource(progressBarElement.getStringElement().getForegroundColor()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void colorizeGlobalJTabbedPane() {
        UIManager.put("TabbedPane.background", theme.getTabbedPaneElement().getActiveTab().getBackgroundColor()); //does not work
        UIManager.put("TabbedPane.foreground", theme.getTabbedPaneElement().getActiveTab().getForegroundColor()); //does not work
        UIManager.put("TabbedPane.unselectedBackground", theme.getTabbedPaneElement().getTab().getBackgroundColor()); //does not work
        UIManager.put("TabbedPane.unselectedForeground", theme.getTabbedPaneElement().getTab().getForegroundColor()); //does not work
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

    private void paintJProgressBar(JProgressBar component) {
        //found no another way to do this
        if (!component.isIndeterminate()) {
//            component.setStringPainted(true);
            component.setOpaque(false);
            component.setBackground(theme.getProgressBarElement().getBackgroundColor());
            component.setForeground(theme.getProgressBarElement().getForegroundColor());

            SwingUtilities.updateComponentTreeUI(component);
        }
    }

    private void paintJTabbedPane(JTabbedPane component) {
        for (int i = 0; i < component.getTabCount(); i++) {
            try {
                final Color bg = theme.getTabbedPaneElement().getTab().getBackgroundColor();

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

        final JTableElement tableElement = theme.getTableElement();

        header.setBackground(tableElement.getHeader().getBackgroundColor());
        header.setForeground(tableElement.getHeader().getForegroundColor());

        component.setSelectionBackground(tableElement.getSelectedRow().getBackgroundColor());
        component.setSelectionForeground(tableElement.getSelectedRow().getForegroundColor());

        component.setBackground(tableElement.getRow().getBackgroundColor());
        component.setForeground(tableElement.getRow().getForegroundColor());

        final TableCellEditor cellEditor = component.getCellEditor(0, 0);
        Component c = cellEditor.getTableCellEditorComponent(component, component.getValueAt(0, 0),
                0 == component.getSelectedRow() && 0 == component.getSelectedColumn(), 0, 0);
        c.setBackground(tableElement.getEditor().getBackgroundColor());
        c.setForeground(tableElement.getEditor().getForegroundColor());
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
