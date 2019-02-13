package com.github.benchdoos.beans.components;

public interface JComboBoxElement extends ThemeElement {

    BinaryElement getButton();

    void setButton(BinaryElement header);

    BinaryElement getRow();

    void setRow(BinaryElement row);

    BinaryElement getSelectedRow();

    void setSelectedRow(BinaryElement selectedRow);

    /*BinaryElement getEditor();

    void setEditor(BinaryElement editor);*/
}
