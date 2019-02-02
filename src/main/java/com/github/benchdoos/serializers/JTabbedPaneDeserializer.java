package com.github.benchdoos.serializers;

import com.github.benchdoos.beans.components.JTabbedPaneElement;
import com.github.benchdoos.beans.components.JTabbedPaneElementImpl;
import com.github.benchdoos.core.ElementConstants;
import com.google.gson.*;

import java.awt.*;
import java.lang.reflect.Type;

public class JTabbedPaneDeserializer implements JsonDeserializer<JTabbedPaneElement> {
    public JTabbedPaneElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        JTabbedPaneElement element = new JTabbedPaneElementImpl();

        final JsonElement background = object.get(ElementConstants.TAB_BACKGROUND);
        if (background != null) {
            element.setTabBackgroundColor(Color.decode(background.getAsString()));
        }

        final JsonElement foreground = object.get(ElementConstants.TAB_FOREGROUND);
        if (foreground != null) {
            element.setTabForegroundColor(Color.decode(foreground.getAsString()));
        }

        final JsonElement active_foreground = object.get(ElementConstants.ACTIVE_TAB_FOREGROUND);
        if (active_foreground != null) {
            element.setActiveTabForegroundColor(Color.decode(active_foreground.getAsString()));
        }

        final JsonElement active_background = object.get(ElementConstants.ACTIVE_TAB_BACKGROUND);
        if (active_background != null) {
            element.setActiveTabBackgroundColor(Color.decode(active_background.getAsString()));
        }
        return element;
    }
}