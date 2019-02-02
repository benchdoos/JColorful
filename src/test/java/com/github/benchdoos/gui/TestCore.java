package com.github.benchdoos.gui;

import com.github.benchdoos.beans.DefaultThemes;
import com.github.benchdoos.core.JColorful;

import javax.swing.*;

public class TestCore {
    public static void main(String[] args) {
        JColorful colorful = new JColorful(DefaultThemes.EXTREMELY_BLACK);
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        TestWindow testWindow = new TestWindow();
        colorful.colorize(testWindow);
        testWindow.setVisible(true);
    }
}
