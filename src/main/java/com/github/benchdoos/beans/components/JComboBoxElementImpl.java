package com.github.benchdoos.beans.components;

public class JComboBoxElementImpl implements JComboBoxElement {

    private BinaryElement button;
    private BinaryElement selectedRow;
    private BinaryElement row;

    @Override
    public BinaryElement getButton() {
        return button;
    }

    @Override
    public void setButton(BinaryElement button) {
        this.button = button;
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
