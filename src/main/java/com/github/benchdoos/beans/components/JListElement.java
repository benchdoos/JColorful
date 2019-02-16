package com.github.benchdoos.beans.components;

public interface JListElement extends RowAbleElement, ThemeElement {
    BinaryElement getRow();

    void setRow(BinaryElement row);

    BinaryElement getSelectedRow();

    void setSelectedRow(BinaryElement selectedRow);

}
