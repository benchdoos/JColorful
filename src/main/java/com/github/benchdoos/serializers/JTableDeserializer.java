package com.github.benchdoos.serializers;

import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.beans.components.BinaryElementImpl;
import com.github.benchdoos.beans.components.JTableElement;
import com.github.benchdoos.beans.components.JTableElementImpl;
import com.github.benchdoos.core.ElementConstants;
import com.google.gson.*;

import java.awt.*;
import java.lang.reflect.Type;

public class JTableDeserializer implements JsonDeserializer<JTableElement> {
    @Override
    public JTableElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        JTableElement element = new JTableElementImpl();

        BinaryElement head = getBinary(object, ElementConstants.TABLE_HEAD);
        element.setHeader(head);

        BinaryElement row = getBinary(object, ElementConstants.TABLE_ROW);
        element.setRow(row);

        BinaryElement selectedRow = getBinary(object, ElementConstants.TABLE_SELECTED_ROW);
        element.setSelectedRow(selectedRow);


        return element;
    }

    private BinaryElement getBinary(JsonObject object, String tableHead) {
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
