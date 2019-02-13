package com.github.benchdoos.beans.components;

import com.github.benchdoos.core.ElementConstants;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.awt.*;

public class ElementsUtils {
    public static BinaryElement getBinary(JsonObject object, String tableHead) {
        final JsonElement headElement = object.get(tableHead);
        return getBinaryElement(headElement);
    }

    public static BinaryElement getBinary(JsonObject object) {
        return getBinaryElement(object);
    }

    private static BinaryElement getBinaryElement(JsonElement headElement) {
        if (headElement != null) {
            BinaryElement binaryElement = new BinaryElementImpl();
            final JsonObject asJsonObject = headElement.getAsJsonObject();
            if (asJsonObject != null) {
                JsonElement background = asJsonObject.get(ElementConstants.BACKGROUND);
                if (background != null) {
                    binaryElement.setBackgroundColor(Color.decode(background.getAsString()));
                }

                JsonElement foreground = asJsonObject.get(ElementConstants.FOREGROUND);
                if (foreground != null) {
                    binaryElement.setForegroundColor(Color.decode(foreground.getAsString()));
                }
            }
            return binaryElement;
        }
        return null;
    }
}
