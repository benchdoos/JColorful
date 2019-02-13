package com.github.benchdoos.core;

import com.github.benchdoos.beans.Theme;
import com.github.benchdoos.beans.components.*;
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

        if (component instanceof JComboBox) {
            painJComboBox((JComboBox) component);
        }

        if (component instanceof JList) {
            painJList((JList) component);
        }

        if (component instanceof JTree) {
            paintJTree((JTree) component);
        }

        if (component instanceof JTabbedPane) {
            new JTabbedPaneManager(theme).paintComponent(component);
        }

        if (component instanceof JTable) {
            new JTableManager(theme).paintComponent(component);
        }

    }

    void colorizeGlobal() {
        System.out.println("Colorizing global for theme: " + theme);
        colorizeGlobalJTabbedPane();
        colorizeGlobalJProgressBar();
        colorizeGlobalJComboBox();
        colorizeGlobalJTree();
    }

    private void painJList(JList component) {
        component.setBackground(theme.getListElement().getRow().getBackgroundColor());
        component.setForeground(theme.getListElement().getRow().getForegroundColor());
        component.setSelectionBackground(theme.getListElement().getSelectedRow().getBackgroundColor());
        component.setSelectionForeground(theme.getListElement().getSelectedRow().getForegroundColor());
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

    private void colorizeGlobalJTree() {
        final JTreeElement treeElement = theme.getTreeElement();
        final BinaryElement row = treeElement.getRow();
        UIManager.put("Tree.textForeground", row.getForegroundColor());//works
        UIManager.put("Tree.textBackground", row.getBackgroundColor());//works
        UIManager.put("Tree.selectionForeground", treeElement.getSelectedRow().getForegroundColor());//works
        UIManager.put("Tree.selectionBackground", treeElement.getSelectedRow().getBackgroundColor());//works
    }

    private void paintJTree(JTree component) {
        component.setBackground(theme.getTreeElement().getBackgroundColor()); //not working
        component.setForeground(theme.getTreeElement().getForegroundColor()); //not working
    }

    private void colorizeGlobalJComboBox() {
          /*ComboBox.background
            ComboBox.buttonBackground
            ComboBox.buttonDarkShadow
            ComboBox.buttonHighlight
            ComboBox.buttonShadow
            ComboBox.disabledBackground
            ComboBox.disabledForeground
            ComboBox.font
            ComboBox.foreground
            ComboBox.isEnterSelectablePopup
            ComboBox.selectionBackground
            ComboBox.selectionForeground
            ComboBox.timeFactor
            ComboBox.togglePopupText*/
        final JComboBoxElement comboBoxElement = theme.getComboBoxElement();
        if (comboBoxElement != null) {
            UIManager.put("ComboBox.background", comboBoxElement.getRow().getBackgroundColor()); //works
            UIManager.put("ComboBox.foreground", comboBoxElement.getRow().getForegroundColor()); //works
            UIManager.put("ComboBox.selectionBackground", comboBoxElement.getSelectedRow().getBackgroundColor()); //works
            UIManager.put("ComboBox.selectionForeground", comboBoxElement.getSelectedRow().getForegroundColor()); //works
        }

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

    private void painJComboBox(JComboBox component) {
        component.setForeground(theme.getComboBoxElement().getButton().getForegroundColor());
        component.setBackground(theme.getComboBoxElement().getButton().getBackgroundColor());//not working
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
