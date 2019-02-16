package com.github.benchdoos.jcolorful.beans.components;

import java.awt.*;

public class JProgressBarElementImpl implements JProgressBarElement {
    private Color backgroundColor;
    private Color foregroundColor;
    private BinaryElement stringElement;

    public JProgressBarElementImpl(Color backgroundColor, Color foregroundColor, BinaryElement stringElement) {
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
        this.stringElement = stringElement;
    }

    public JProgressBarElementImpl() {
    }

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
