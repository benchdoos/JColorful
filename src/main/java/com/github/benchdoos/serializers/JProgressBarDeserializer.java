package com.github.benchdoos.serializers;

import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.beans.components.ElementsUtils;
import com.github.benchdoos.beans.components.JProgressBarElement;
import com.github.benchdoos.beans.components.JProgressBarElementImpl;
import com.github.benchdoos.core.ElementConstants;
import com.google.gson.*;

import java.lang.reflect.Type;

public class JProgressBarDeserializer implements JsonDeserializer<JProgressBarElement> {
    public JProgressBarElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        JProgressBarElement element = new JProgressBarElementImpl();

        BinaryElement bin = ElementsUtils.getBinary(object);
        element.setForegroundColor(bin.getForegroundColor());
        element.setBackgroundColor(bin.getBackgroundColor());

        BinaryElement string = ElementsUtils.getBinary(object, ElementConstants.STRING_ELEMENT);
        element.setStringElement(string);

        return element;
    }
}