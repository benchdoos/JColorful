package com.github.benchdoos.beans.components;

public class JTableElementImpl implements JTableElement {
    private BinaryElement header;
    private BinaryElement selectedRow;
    private BinaryElement row;

    @Override
    public BinaryElement getHeader() {
        return this.header;
    }

    @Override
    public void setHeader(BinaryElement header) {
        this.header = header;
    }

    @Override
    public BinaryElement getRow() {
        return this.row;
    }

    @Override
    public void setRow(BinaryElement row) {
        this.row = row;
    }

    @Override
    public BinaryElement getSelectedRow() {
        return this.selectedRow;
    }

    @Override
    public void setSelectedRow(BinaryElement selectedRow) {
        this.selectedRow = selectedRow;
    }
}
