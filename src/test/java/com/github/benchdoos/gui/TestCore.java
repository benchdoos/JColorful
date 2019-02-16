package com.github.benchdoos.gui;

import com.github.benchdoos.beans.Theme;
import com.github.benchdoos.beans.ThemeImpl;
import com.github.benchdoos.core.JColorful;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Enumeration;

import static java.util.Collections.list;

public class TestCore {
    static Theme defaultWindowsTheme = new ThemeImpl().initDefaults();

    public static void main(String[] args) {
        JColorful colorful = new JColorful(JColorful.EXTREMELY_BLACK);
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        colorful.colorizeGlobal();
//        printUIManagerKeys();


        TestWindow testWindow = new TestWindow();
        colorful.colorize(testWindow);
        SwingUtilities.invokeLater(() -> testWindow.setVisible(true));
    }

    private static void printUIManagerKeys() {
        UIDefaults defaults = UIManager.getDefaults();
        Enumeration<Object> keysEnumeration = defaults.keys();
        ArrayList<Object> keysList = list(keysEnumeration);
        for (Object key : keysList) {
            System.out.println("UIManager: " + key + " - " + UIManager.get(key));
        }
    }
}
