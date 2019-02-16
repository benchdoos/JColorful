package com.github.benchdoos.beans.components;

public class JListElementImpl implements JListElement {
    private BinaryElement row;
    private BinaryElement selectedRow;

    public JListElementImpl(BinaryElement row, BinaryElement selectedRow) {
        this.row = row;
        this.selectedRow = selectedRow;
    }

    public JListElementImpl() {
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
