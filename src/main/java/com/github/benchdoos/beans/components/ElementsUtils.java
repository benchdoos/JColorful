package com.github.benchdoos.beans.components;

import com.github.benchdoos.core.ElementConstants;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.awt.*;

public class ElementsUtils {
    public static BinaryElement getBinary(JsonObject object, String tableHead) {
        System.out.println("obj: " + object + "\n head:" + tableHead);
        final JsonElement headElement = object.get(tableHead);
        return getBinaryElement(headElement);
    }

    public static BinaryElement getBinary(JsonObject object) {
        return getBinaryElement(object);
    }

    private static BinaryElement getBinaryElement(JsonElement headElement) {
        BinaryElement binaryElement = new BinaryElementImpl();
        JsonElement background = headElement.getAsJsonObject().get(ElementConstants.BACKGROUND);
        if (background != null) {
            binaryElement.setBackgroundColor(Color.decode(background.getAsString()));
        }

        JsonElement foreground = headElement.getAsJsonObject().get(ElementConstants.FOREGROUND);
        if (foreground != null) {
            binaryElement.setForegroundColor(Color.decode(foreground.getAsString()));
        }
        return binaryElement;
    }
}
