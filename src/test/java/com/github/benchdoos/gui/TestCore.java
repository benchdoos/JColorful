package com.github.benchdoos.gui;

import com.github.benchdoos.beans.DefaultThemes;
import com.github.benchdoos.core.JColorful;

public class TestCore {
    public static void main(String[] args) {
        JColorful colorful = new JColorful(DefaultThemes.EXTREMELY_BLACK);
        /*UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());*/
        TestWindow testWindow = new TestWindow();
        colorful.colorize(testWindow);
        testWindow.setVisible(true);
    }
}
