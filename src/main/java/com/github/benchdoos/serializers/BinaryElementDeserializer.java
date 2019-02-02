package com.github.benchdoos.serializers;

import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.beans.components.BinaryElementImpl;
import com.github.benchdoos.core.ElementConstants;
import com.github.benchdoos.core.ModelConstants;
import com.google.gson.*;

import java.awt.*;
import java.lang.reflect.Type;

public class BinaryElementDeserializer implements JsonDeserializer<BinaryElement> {
    public BinaryElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        BinaryElementImpl binaryElement = new BinaryElementImpl();

        final JsonElement name = object.get(ModelConstants.OBJECT_TYPE);
        if (name != null) {
            binaryElement.setName(name.getAsString());
        }

        final JsonElement background = object.get(ElementConstants.BACKGROUND);
        if (background != null) {
            binaryElement.setBackgroundColor(Color.decode(background.getAsString()));
        }

        final JsonElement foreground = object.get(ElementConstants.FOREGROUND);
        if (foreground != null) {
            binaryElement.setForegroundColor(Color.decode(foreground.getAsString()));
        }

        return binaryElement;
    }
}