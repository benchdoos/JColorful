package com.github.benchdoos.serializers;

import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.beans.components.ElementsUtils;
import com.github.benchdoos.beans.components.JTreeElement;
import com.github.benchdoos.beans.components.JTreeElementImpl;
import com.github.benchdoos.core.ElementConstants;
import com.google.gson.*;

import java.lang.reflect.Type;

public class JTreeDeserializer implements JsonDeserializer<JTreeElement> {
    @Override
    public JTreeElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        JTreeElement element = new JTreeElementImpl();
        try {
            BinaryElement binary = ElementsUtils.getBinary(object);
            element.setRow(binary);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
