package com.github.benchdoos.core;

import com.github.benchdoos.beans.JTheme;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class Colorize {
    private JTheme theme;

    public Colorize(JTheme theme) {
        if (theme == null) {
            throw new IllegalArgumentException("Colorize theme can not be null");
        }
        this.theme = theme;
    }

    public void colorize(Component component) {
        final Color backgroundColor = theme.getCommonComponent().getBackgroundColor();
        /*System.out.println("> " + String.format("#%02x%02x%02x",
                backgroundColor.getRed(), backgroundColor.getGreen(), backgroundColor.getBlue()));*/
        component.setBackground(backgroundColor);
        component.setForeground(theme.getCommonComponent().getForegroundColor());

        if (component instanceof JTextComponent) {
            JTextComponent textComponent = (JTextComponent) component;
            textComponent.setBackground(theme.getTextComponentElement().getBackgroundColor());
            textComponent.setForeground(theme.getTextComponentElement().getForegroundColor());
            textComponent.setCaretColor(theme.getTextComponentElement().getCaretColor());
        }

        if (component instanceof JCheckBox) {
            UIManager.put("CheckBox.focus",Color.RED);
        }

    }
}
