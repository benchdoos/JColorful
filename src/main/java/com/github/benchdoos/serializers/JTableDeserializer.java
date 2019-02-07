package com.github.benchdoos.serializers;

import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.beans.components.ElementsUtils;
import com.github.benchdoos.beans.components.JTableElement;
import com.github.benchdoos.beans.components.JTableElementImpl;
import com.github.benchdoos.core.ElementConstants;
import com.google.gson.*;

import java.lang.reflect.Type;

public class JTableDeserializer implements JsonDeserializer<JTableElement> {
    @Override
    public JTableElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        JTableElement element = new JTableElementImpl();

        try {
            BinaryElement head = ElementsUtils.getBinary(object, ElementConstants.TABLE_HEAD);
            element.setHeader(head);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BinaryElement row = ElementsUtils.getBinary(object, ElementConstants.TABLE_ROW);
            element.setRow(row);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BinaryElement selectedRow = ElementsUtils.getBinary(object, ElementConstants.TABLE_SELECTED_ROW);
            element.setSelectedRow(selectedRow);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BinaryElement editor = ElementsUtils.getBinary(object, ElementConstants.EDITOR);
            element.setEditor(editor);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return element;
    }


}
