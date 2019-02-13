package com.github.benchdoos.core;

import com.github.benchdoos.beans.Theme;
import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.beans.components.JProgressBarElement;
import com.github.benchdoos.beans.components.JTabbedPaneElement;
import com.github.benchdoos.beans.components.JTextComponentElement;
import com.github.benchdoos.managers.JTabbedPaneManager;
import com.github.benchdoos.managers.JTableManager;

import javax.swing.*;
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

        if (component instanceof JCheckBox) {
            paintJCheckBox((JCheckBox) component);
        }
        if (component instanceof JRadioButton) {
            paintJRadioButton((JRadioButton) component);
        }

        if (component instanceof JCheckBox) {
            paintJCheckBox((JCheckBox) component);
        }

        if (component instanceof JProgressBar) {
            paintJProgressBar((JProgressBar) component);
        }


        if (component instanceof JCheckBox) {
            paintJCheckBox((JCheckBox) component);
        }

        if (component instanceof JTabbedPane) {
            new JTabbedPaneManager(theme).paintComponent(component);
        }

        if (component instanceof JTable) {
            new JTableManager(theme).paintComponent(component);
        }

    }

    private void colorizeBinaryElement(Component component, BinaryElement element) {
        if (element != null) {
            try {
                component.setBackground(element.getBackgroundColor());
                component.setForeground(element.getForegroundColor());
            } catch (Exception e) {
                e.printStackTrace();
            }
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
            final BinaryElement stringElement = progressBarElement.getStringElement();
            if (stringElement != null) {
                UIManager.put("ProgressBar.background", stringElement.getBackgroundColor()); //does not work
                UIManager.put("ProgressBar.foreground", stringElement.getForegroundColor()); //does not work

                UIManager.put("ProgressBar.selectionBackground", stringElement.getBackgroundColor());
                UIManager.put("ProgressBar.selectionForeground", stringElement.getForegroundColor());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void colorizeGlobalJTabbedPane() {
        final JTabbedPaneElement tabbedPaneElement = theme.getTabbedPaneElement();
        if (tabbedPaneElement != null) {
            try {
                final BinaryElement activeTab = tabbedPaneElement.getActiveTab();
                if (activeTab != null) {
                    UIManager.put("TabbedPane.background", activeTab.getBackgroundColor()); //does not work
                    UIManager.put("TabbedPane.foreground", activeTab.getForegroundColor()); //does not work
                    UIManager.put("TabbedPane.selected", activeTab.getBackgroundColor()); //does not work
                }
                final BinaryElement tab = tabbedPaneElement.getTab();
                if (tab != null) {
                    UIManager.put("TabbedPane.unselectedBackground", tab.getBackgroundColor()); //does not work
                    UIManager.put("TabbedPane.unselectedForeground", tab.getForegroundColor()); //does not work
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void paintJButton(JButton component) {
        final boolean opaque = component.isOpaque();
        final BinaryElement buttonElement = theme.getButtonElement();
        colorizeBinaryElement(component, buttonElement);
        if (buttonElement != null) {
            component.setContentAreaFilled(false);
            component.setOpaque(opaque);
        }
    }

    private void paintJCheckBox(JCheckBox component) {
        final BinaryElement checkBoxElement = theme.getCheckBoxElement();
        colorizeBinaryElement(component, checkBoxElement);
    }

    private void paintJProgressBar(JProgressBar component) {
        //found no another way to do this
        if (!component.isIndeterminate()) {
//            component.setStringPainted(true);
            component.setOpaque(false);
            final JProgressBarElement progressBarElement = theme.getProgressBarElement();
            if (progressBarElement != null) {
                component.setBackground(progressBarElement.getBackgroundColor());
                component.setForeground(progressBarElement.getForegroundColor());
            }

            SwingUtilities.updateComponentTreeUI(component);
        }
    }

    private void paintJRadioButton(JRadioButton component) {
        final BinaryElement radioButtonElement = theme.getRadioButtonElement();
        colorizeBinaryElement(component, radioButtonElement);
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
