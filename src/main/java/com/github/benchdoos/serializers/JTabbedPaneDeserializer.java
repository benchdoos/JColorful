package com.github.benchdoos.serializers;

import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.beans.components.ElementsUtils;
import com.github.benchdoos.beans.components.JTabbedPaneElement;
import com.github.benchdoos.beans.components.JTabbedPaneElementImpl;
import com.github.benchdoos.core.ElementConstants;
import com.google.gson.*;

import java.lang.reflect.Type;

public class JTabbedPaneDeserializer implements JsonDeserializer<JTabbedPaneElement> {
    public JTabbedPaneElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        JTabbedPaneElement element = new JTabbedPaneElementImpl();

        BinaryElement tab = ElementsUtils.getBinary(object, ElementConstants.TAB);
        element.setTab(tab);

        BinaryElement activeTab = ElementsUtils.getBinary(object, ElementConstants.ACTIVE_TAB);
        element.setActiveTab(activeTab);

        return element;
    }
}