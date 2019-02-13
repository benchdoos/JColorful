package com.github.benchdoos.serializers;

import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.beans.components.ElementsUtils;
import com.github.benchdoos.beans.components.JTextComponentElement;
import com.github.benchdoos.beans.components.JTextComponentElementImpl;
import com.github.benchdoos.core.ElementConstants;
import com.google.gson.*;

import java.awt.*;
import java.lang.reflect.Type;

public class JTextComponentDeserializer implements JsonDeserializer<JTextComponentElement> {
    public JTextComponentElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        JTextComponentElement element = new JTextComponentElementImpl();

        try {
            BinaryElement binary = ElementsUtils.getBinary(object);
            element.setBackgroundColor(binary.getBackgroundColor());
            element.setForegroundColor(binary.getForegroundColor());
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            final JsonElement caretColor = object.get(ElementConstants.CARET);
            if (caretColor != null) {
                element.setCaretColor(Color.decode(caretColor.getAsString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            final JsonElement selectionElement = object.get(ElementConstants.SELECTION);
            if (selectionElement != null) {
                element.setSelectionColor(Color.decode(selectionElement.getAsString()));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return element;
    }
}