package com.github.benchdoos.jcolorful.beans.components;

import java.awt.*;

public interface JTextComponentElement extends BinaryElement, ThemeElement {
    Color getCaretColor();

    void setCaretColor(Color color);

    Color getSelectionColor();

    void setSelectionColor(Color color);
}
