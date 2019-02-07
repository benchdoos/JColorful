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

        try {
            BinaryElement tab = ElementsUtils.getBinary(object, ElementConstants.TAB);
            element.setTab(tab);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BinaryElement activeTab = ElementsUtils.getBinary(object, ElementConstants.ACTIVE_TAB);
            element.setActiveTab(activeTab);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return element;
    }
}