package com.github.benchdoos.beans.components;

import java.awt.*;

public class JTextComponentElementImpl implements JTextComponentElement {
    private String name;
    private Color backgroundColor;
    private Color foregroundColor;
    private Color caretColor;
    private Color selectionColor;

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
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
