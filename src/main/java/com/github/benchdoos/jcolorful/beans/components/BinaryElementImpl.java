package com.github.benchdoos.jcolorful.beans.components;

import java.awt.*;

public class BinaryElementImpl implements BinaryElement {
    private Color backgroundColor;
    private Color foregroundColor;

    public BinaryElementImpl() {
    }

    public BinaryElementImpl(Color backgroundColor, Color foregroundColor) {
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
    }

    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

    public Color getForegroundColor() {
        return this.foregroundColor;
    }

    public void setForegroundColor(Color color) {
        this.foregroundColor = color;
    }

}
