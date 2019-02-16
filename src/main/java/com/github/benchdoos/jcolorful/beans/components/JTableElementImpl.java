package com.github.benchdoos.jcolorful.beans.components;

public class JTableElementImpl implements JTableElement {
    private BinaryElement header;
    private BinaryElement selectedRow;
    private BinaryElement row;
    private BinaryElement editor;

    public JTableElementImpl(BinaryElement header, BinaryElement selectedRow, BinaryElement row, BinaryElement editor) {
        this.header = header;
        this.selectedRow = selectedRow;
        this.row = row;
        this.editor = editor;
    }

    public JTableElementImpl() {
    }

    @Override
    public BinaryElement getEditor() {
        return editor;
    }

    @Override
    public void setEditor(BinaryElement editor) {
        this.editor = editor;
    }

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
