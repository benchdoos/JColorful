package com.github.benchdoos.core;

import com.github.benchdoos.beans.Theme;
import com.github.benchdoos.beans.components.*;
import com.github.benchdoos.managers.JTabbedPaneManager;
import com.github.benchdoos.managers.JTableManager;
import com.github.benchdoos.utils.Logging;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;

class Atomizer {
    private static final Logger log = LogManager.getLogger(Logging.getCurrentClassName());

    private Theme theme;

    Atomizer(Theme theme) {
        if (theme == null) {
            throw new IllegalArgumentException("Atomizer theme can not be null");
        }
        this.theme = theme;
    }

    void colorize(Component component) {
        log.debug("Colorizing component: {}", component.getClass().getName());

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

    private void colorizeBinaryElement(Component component, BinaryElement element) {
        if (element != null) {
            try {
                component.setBackground(element.getBackgroundColor());
                component.setForeground(element.getForegroundColor());
            } catch (Exception e) {
                log.debug("Could not colorize binary element: {}", component.getClass().getName(), e);
            }
        }
    }

    void colorizeGlobal() {
        log.info("Colorizing global for theme: {}", theme);
        colorizeGlobalJTabbedPane();
        colorizeGlobalJProgressBar();
        colorizeGlobalJComboBox();
        colorizeGlobalJTree();
    }

    private void colorizeGlobalJComboBox() {
        try {
            final JComboBoxElement comboBoxElement = theme.getComboBoxElement();
            if (comboBoxElement != null) {
                UIManager.put("ComboBox.background", comboBoxElement.getRow().getBackgroundColor()); //works
                UIManager.put("ComboBox.foreground", comboBoxElement.getRow().getForegroundColor()); //works
                UIManager.put("ComboBox.selectionBackground", comboBoxElement.getSelectedRow().getBackgroundColor()); //works
                UIManager.put("ComboBox.selectionForeground", comboBoxElement.getSelectedRow().getForegroundColor()); //works
            }
        } catch (Exception e) {
            log.debug("Could not colorize global JComboBox", e);
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
            log.debug("Could not colorize global JProgressBar", e);
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
                }
                final BinaryElement tab = tabbedPaneElement.getTab();
                if (tab != null) {
                    UIManager.put("TabbedPane.unselectedBackground", tab.getBackgroundColor()); //does not work
                    UIManager.put("TabbedPane.unselectedForeground", tab.getForegroundColor()); //does not work
                }
            } catch (Exception e) {
                log.debug("Could not colorize global JTabbedPane", e);
            }
        }

    }

    private void colorizeGlobalJTree() {
        try {
            final JTreeElement treeElement = theme.getTreeElement();
            final BinaryElement row = treeElement.getRow();
            UIManager.put("Tree.textForeground", row.getForegroundColor());//works
            UIManager.put("Tree.textBackground", row.getBackgroundColor());//works
            UIManager.put("Tree.selectionForeground", treeElement.getSelectedRow().getForegroundColor());//works
            UIManager.put("Tree.selectionBackground", treeElement.getSelectedRow().getBackgroundColor());//works
        } catch (Exception e) {
            log.debug("Could not colorize global JTree", e);
        }
    }

    private void painJComboBox(JComboBox component) {
        try {
            component.setForeground(theme.getComboBoxElement().getButton().getForegroundColor());
            component.setBackground(theme.getComboBoxElement().getButton().getBackgroundColor());//not working
        } catch (Exception e) {
            log.warn("Could not paint JComboBox", e);
        }
    }

    private void painJList(JList component) {
        try {
            component.setBackground(theme.getListElement().getRow().getBackgroundColor());
            component.setForeground(theme.getListElement().getRow().getForegroundColor());
            component.setSelectionBackground(theme.getListElement().getSelectedRow().getBackgroundColor());
            component.setSelectionForeground(theme.getListElement().getSelectedRow().getForegroundColor());
        } catch (Exception e) {
            log.debug("Could not paint JList", e);
        }
    }

    private void paintJButton(JButton component) {
        try {
            final boolean opaque = component.isOpaque();
            final BinaryElement buttonElement = theme.getButtonElement();
            colorizeBinaryElement(component, buttonElement);
            if (buttonElement != null) {
                component.setContentAreaFilled(false);
                component.setOpaque(opaque);
            }
        } catch (Exception e) {
            log.debug("Could not pain JButton", e);
        }
    }

    private void paintJCheckBox(JCheckBox component) {
        try {
            final BinaryElement checkBoxElement = theme.getCheckBoxElement();
            colorizeBinaryElement(component, checkBoxElement);
        } catch (Exception e) {
            log.debug("Could not paint JCheckBox", e);
        }
    }

    private void paintJProgressBar(JProgressBar component) {
        //found no another way to do this
        try {
            if (!component.isIndeterminate()) {
                component.setOpaque(false);
                final JProgressBarElement progressBarElement = theme.getProgressBarElement();
                if (progressBarElement != null) {
                    component.setBackground(progressBarElement.getBackgroundColor());
                    component.setForeground(progressBarElement.getForegroundColor());
                }

                SwingUtilities.updateComponentTreeUI(component);
            }
        } catch (Exception e) {
            log.debug("Could not pain JProgressBar", e);
        }
    }

    private void paintJRadioButton(JRadioButton component) {
        try {
            final BinaryElement radioButtonElement = theme.getRadioButtonElement();
            colorizeBinaryElement(component, radioButtonElement);
        } catch (Exception e) {
            log.debug("Could not paint JRadioButton", e);
        }
    }

    private void paintJTextComponent(JTextComponent component) {
        try {
            final JTextComponentElement componentElement = theme.getTextComponentElement();
            if (componentElement != null) {
                component.setBackground(componentElement.getBackgroundColor());
                component.setForeground(componentElement.getForegroundColor());
                component.setCaretColor(componentElement.getCaretColor());
                component.setSelectionColor(componentElement.getSelectionColor());
            }
        } catch (Exception e) {
            log.debug("Could not paint JTextComponent", e);
        }
    }

    private void paintJTree(JTree component) {
        try {
            component.setBackground(theme.getTreeElement().getBackgroundColor()); //not working
            component.setForeground(theme.getTreeElement().getForegroundColor()); //not working
        } catch (Exception e) {
            log.debug("Could not paint JTree", e);
        }
    }
}
