package com.github.benchdoos.beans.components;

import java.awt.*;

public class JProgressBarElementImpl implements JProgressBarElement {
    private Color backgroundColor;
    private Color foregroundColor;
    private BinaryElement stringElement;

    @Override
    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override
    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

    @Override
    public Color getForegroundColor() {
        return this.foregroundColor;
    }

    @Override
    public void setForegroundColor(Color color) {
        this.foregroundColor = color;
    }

    @Override
    public BinaryElement getStringElement() {
        return this.stringElement;
    }

    @Override
    public void setStringElement(BinaryElement stringElement) {
        this.stringElement = stringElement;
    }
}
