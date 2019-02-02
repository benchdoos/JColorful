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
        final Color commonBackgroundColor = theme.getCommonComponent().getBackgroundColor();
        /*System.out.println("> " + String.format("#%02x%02x%02x",
                commonBackgroundColor.getRed(), commonBackgroundColor.getGreen(), commonBackgroundColor.getBlue()));*/
        component.setBackground(commonBackgroundColor);
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

    }
}
