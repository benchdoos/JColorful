package com.github.benchdoos.serializers;

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

        final JsonElement background = object.get(ElementConstants.BACKGROUND);
        if (background != null) {
            element.setBackgroundColor(Color.decode(background.getAsString()));
        }

        final JsonElement foreground = object.get(ElementConstants.FOREGROUND);
        if (foreground != null) {
            element.setForegroundColor(Color.decode(foreground.getAsString()));
        }

        final JsonElement caretColor = object.get(ElementConstants.CARET);
        if (caretColor != null) {
            element.setCaretColor(Color.decode(caretColor.getAsString()));
        }

        return element;
    }
}