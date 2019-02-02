package com.github.benchdoos.beans;

import java.util.Scanner;

public class DefaultThemes {
    private static final String CHARSET = "UTF-8";
    public static final JTheme EXTREMELY_BLACK = new DefaultThemes().getTheme("/presets/extremelyBlack.json");
    public static final JTheme GRAY = new DefaultThemes().getTheme("/presets/gray.json");


    private JTheme getTheme(String path) {
        Scanner scanner = new Scanner(DefaultThemes.class.getResourceAsStream(path)).useDelimiter("\\A");
        String content = scanner.hasNext() ? scanner.next() : "";
        return new ThemeBean(content);
    }
}
