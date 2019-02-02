package com.github.benchdoos.beans;

import java.util.Scanner;

public class DefaultThemes {
    public static final Theme EXTREMELY_BLACK = new DefaultThemes().getTheme("/presets/extremelyBlack.json");
    public static final Theme DARK_GRAY = new DefaultThemes().getTheme("/presets/darkGray.json");


    private Theme getTheme(String path) {
        Scanner scanner = new Scanner(DefaultThemes.class.getResourceAsStream(path)).useDelimiter("\\A");
        String content = scanner.hasNext() ? scanner.next() : "";
        return new ThemeBean(content);
    }
}
