package com.github.benchdoos.serializers;

import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.beans.components.ElementsUtils;
import com.github.benchdoos.beans.components.JListElement;
import com.github.benchdoos.beans.components.JListElementImpl;
import com.github.benchdoos.core.ElementConstants;
import com.google.gson.*;

import java.lang.reflect.Type;

public class JListDeserializer implements JsonDeserializer<JListElement> {
    @Override
    public JListElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        JListElement element = new JListElementImpl();
        try {
            BinaryElement row = ElementsUtils.getBinary(object, ElementConstants.ROW);
            element.setRow(row);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BinaryElement selectedRow = ElementsUtils.getBinary(object, ElementConstants.SELECTED_ROW);
            element.setSelectedRow(selectedRow);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return element;
    }


}
