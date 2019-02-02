package com.github.benchdoos.beans.components;

import com.github.benchdoos.core.ElementConstants;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.awt.*;

public class ElementsUtils {
    public static BinaryElement getBinary(JsonObject object, String tableHead) {
        BinaryElement binaryElement = new BinaryElementImpl();
        final JsonElement headElement = object.get(tableHead);

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
