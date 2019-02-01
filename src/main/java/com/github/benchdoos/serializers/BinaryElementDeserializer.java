package com.github.benchdoos.serializers;

import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.beans.components.BinaryElementImpl;
import com.github.benchdoos.core.ElementConstants;
import com.google.gson.*;

import java.awt.*;
import java.lang.reflect.Type;

import static com.github.benchdoos.core.ModelConstants.COMMON;
import static com.github.benchdoos.core.ModelConstants.OBJECT_TYPE;

public class BinaryElementDeserializer implements JsonDeserializer<BinaryElement>{
    public BinaryElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        final JsonElement objectType = object.get(OBJECT_TYPE);
        if (objectType.getAsString().equalsIgnoreCase(COMMON)) {
            BinaryElementImpl binaryElement = new BinaryElementImpl();

            final JsonElement background = object.get(ElementConstants.BACKGROUND);
            if (background != null) {
                binaryElement.setBackgroundColor(Color.decode(background.getAsString()));
            }

            final JsonElement foreground = object.get(ElementConstants.FOREGROUND);
            if (foreground != null) {
                binaryElement.setForegroundColor(Color.decode(foreground.getAsString()));
            }

            return binaryElement;

        } else throw new IllegalArgumentException("objectType on index 0 should be \"common\"");

    }
}