package com.github.benchdoos.managers;

import java.awt.*;

public interface Manager<T extends Component> {
    void paintComponent(T component);

}
