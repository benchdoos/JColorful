package com.github.benchdoos.beans.components;

import java.awt.*;

public class JTextComponentElementImpl implements JTextComponentElement {
    private Color backgroundColor;
    private Color foregroundColor;
    private Color caretColor;

    @Override
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public Color getCaretColor() {
        return caretColor;
    }

    @Override
    public void setCaretColor(Color caretColor) {
        this.caretColor = caretColor;
    }

    @Override
    public Color getForegroundColor() {
        return foregroundColor;
    }

    @Override
    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }
}
