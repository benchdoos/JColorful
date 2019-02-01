package com.github.benchdoos.serializers;

import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.beans.components.BinaryElementImpl;
import com.google.gson.*;

import java.awt.*;
import java.lang.reflect.Type;


import com.google.gson.*;

import java.lang.reflect.Type;

public class BinaryElementDeserializer implements JsonDeserializer<BinaryElement>{
    public BinaryElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        System.out.println("obj: " + object);

        final JsonElement objectType = object.get("objectType");
        if (objectType.getAsString().equalsIgnoreCase("common")) {
            BinaryElementImpl binaryElement = new BinaryElementImpl();

            final JsonElement background = object.get("background");
            if (background != null) {
                binaryElement.setBackgroundColor(Color.decode(background.getAsString()));
            }

            final JsonElement foreground = object.get("foreground");
            if (foreground != null) {
                binaryElement.setForegroundColor(Color.decode(foreground.getAsString()));
            }

            return binaryElement;

        } else throw new IllegalArgumentException("objectType on index 0 should be \"common\"");

    }
}