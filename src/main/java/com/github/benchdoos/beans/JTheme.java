package com.github.benchdoos.beans;

import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.beans.components.JTextComponentElement;

import javax.swing.text.JTextComponent;

public interface JTheme {

    BinaryElement getCommonComponent();

    JTextComponentElement getTextComponentElement();
}
