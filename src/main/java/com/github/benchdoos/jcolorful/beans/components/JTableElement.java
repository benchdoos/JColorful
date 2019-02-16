package com.github.benchdoos.jcolorful.beans.components;

public interface JTableElement extends ThemeElement {

    BinaryElement getHeader();

    void setHeader(BinaryElement header);

    BinaryElement getRow();

    void setRow(BinaryElement row);

    BinaryElement getSelectedRow();

    void setSelectedRow(BinaryElement selectedRow);

    BinaryElement getEditor();

    void setEditor(BinaryElement editor);
}
