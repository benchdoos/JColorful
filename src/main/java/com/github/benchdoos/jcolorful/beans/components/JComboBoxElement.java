package com.github.benchdoos.jcolorful.beans.components;

public interface JComboBoxElement extends RowAbleElement, ThemeElement {

    BinaryElement getButton();

    void setButton(BinaryElement header);

    BinaryElement getRow();

    void setRow(BinaryElement row);

    BinaryElement getSelectedRow();

    void setSelectedRow(BinaryElement selectedRow);
}
