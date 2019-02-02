package com.github.benchdoos.beans.components;

import java.awt.*;

public class BinaryElementImpl implements BinaryElement {
    private String name;
    private Color backgroundColor;
    private Color foregroundColor;

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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
