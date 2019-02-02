package com.github.benchdoos.beans;

import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.beans.components.JTextComponentElement;

public interface Theme {

    String getAuthor();

    void setAuthor(String author);

    BinaryElement getCommonComponent();

    String getName();

    void setName(String name);

    JTextComponentElement getTextComponentElement();

    int getVersion();

    void setVersion(int version);
}