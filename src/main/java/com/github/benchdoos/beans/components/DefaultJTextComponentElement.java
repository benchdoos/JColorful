package com.github.benchdoos.beans.components;

import java.awt.*;

public class DefaultJTextComponentElement implements JTextComponentElement {
    private Color backgroundColor;
    private Color foregroundColor;
    private Color caretColor;
    private Color selectionColor;


    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

    public Color getCaretColor() {
        return this.caretColor;
    }

    public void setCaretColor(Color color) {
        this.caretColor = color;
    }

    public Color getForegroundColor() {
        return this.foregroundColor;
    }

    public void setForegroundColor(Color color) {
        this.foregroundColor = color;
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
