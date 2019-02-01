package com.github.benchdoos.beans;

import sun.misc.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class DefaultThemes {
    private static final String CHARSET = "UTF-8";
    public static final JTheme EXTREMELY_BLACK = new DefaultThemes().getTheme("/presets/extremelyBlack.json");
    public static final JTheme GRAY = new DefaultThemes().getTheme("/presets/gray.json");


    private JTheme getTheme(String path) {
        Scanner s = new Scanner(DefaultThemes.class.getResourceAsStream(path)).useDelimiter("\\A");
        String shaderCode = s.hasNext() ? s.next() : "";
        return new ThemeBean(shaderCode);
    }
}
