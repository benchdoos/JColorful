package com.github.benchdoos.beans.components;

import java.awt.*;

public class JTextComponentElementImpl implements JTextComponentElement {
    private Color backgroundColor;
    private Color foregroundColor;
    private Color caretColor;
    private Color selectionColor;

    public JTextComponentElementImpl(Color backgroundColor, Color foregroundColor, Color caretColor, Color selectionColor) {
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
        this.caretColor = caretColor;
        this.selectionColor = selectionColor;
    }

    public JTextComponentElementImpl() {
    }

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

    @Override
    public Color getSelectionColor() {
        return selectionColor;
    }

    @Override
    public void setSelectionColor(Color selectionColor) {
        this.selectionColor = selectionColor;
    }
}
