package com.github.benchdoos.beans.components;

public class RowAbleElementImpl implements RowAbleElement {
    private BinaryElement row;
    private BinaryElement selectedRow;

    public RowAbleElementImpl(BinaryElement row, BinaryElement selectedRow) {
        this.row = row;
        this.selectedRow = selectedRow;
    }

    public RowAbleElementImpl() {
    }

    @Override
    public BinaryElement getRow() {
        return row;
    }

    public void setRow(BinaryElement row) {
        this.row = row;
    }

    @Override
    public BinaryElement getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(BinaryElement selectedRow) {
        this.selectedRow = selectedRow;
    }
}
