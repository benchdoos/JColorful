package com.github.benchdoos.beans.components;

import java.awt.*;

public class JTreeElementImpl implements JTreeElement {
    private Color backgroundColor;
    private Color foregroundColor;
    private BinaryElement row;
    private BinaryElement selectedRow;

    @Override
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
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
    public BinaryElement getRow() {
        return row;
    }

    @Override
    public void setRow(BinaryElement row) {
        this.row = row;
    }

    @Override
    public BinaryElement getSelectedRow() {
        return selectedRow;
    }

    @Override
    public void setSelectedRow(BinaryElement selectedRow) {
        this.selectedRow = selectedRow;
    }
}
