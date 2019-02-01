package com.github.benchdoos.core;

import com.github.benchdoos.beans.JTheme;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
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
        component.setBackground(theme.getCommonComponent().getBackgroundColor());
        component.setForeground(theme.getCommonComponent().getForegroundColor());

        if (component instanceof JComponent) {
            final Border border = ((JComponent) component).getBorder();
            if (border != null) {
                if (border instanceof LineBorder) {
                    ((JComponent) component).setBorder(new LineBorder(Color.getColor("#FFFFFF")));
                }
            }
        }

        if (component instanceof JTextComponent) {
            JTextComponent textComponent = (JTextComponent) component;
//            textComponent.setCaretColor(theme.getTextComponentElement().getCaretColor());
        }

        if (component instanceof JCheckBox) {
            UIManager.put("CheckBox.focus",Color.RED);
        }

    }
}
