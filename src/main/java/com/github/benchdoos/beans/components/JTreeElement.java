package com.github.benchdoos.beans.components;

public interface JTreeElement extends ThemeElement, BinaryElement {
    BinaryElement getRow();

    void setRow(BinaryElement row);

    BinaryElement getSelectedRow();

    void setSelectedRow(BinaryElement selectedRow);

}