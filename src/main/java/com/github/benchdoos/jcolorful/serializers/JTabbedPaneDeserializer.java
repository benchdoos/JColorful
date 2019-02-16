package com.github.benchdoos.jcolorful.serializers;

import com.github.benchdoos.jcolorful.beans.components.BinaryElement;
import com.github.benchdoos.jcolorful.beans.components.ElementsUtils;
import com.github.benchdoos.jcolorful.beans.components.JTabbedPaneElement;
import com.github.benchdoos.jcolorful.beans.components.JTabbedPaneElementImpl;
import com.github.benchdoos.jcolorful.core.ElementConstants;
import com.github.benchdoos.jcolorful.utils.Logging;
import com.google.gson.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;

public class JTabbedPaneDeserializer implements JsonDeserializer<JTabbedPaneElement> {
    private static final Logger log = LogManager.getLogger(Logging.getCurrentClassName());

    public JTabbedPaneElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        JTabbedPaneElement element = new JTabbedPaneElementImpl();

        try {
            BinaryElement tab = ElementsUtils.getBinary(object, ElementConstants.TAB);
            element.setTab(tab);
        } catch (Exception e) {
            log.debug("Could not get BinaryElement for tab", e);
        }

        try {
            BinaryElement activeTab = ElementsUtils.getBinary(object, ElementConstants.ACTIVE_TAB);
            element.setActiveTab(activeTab);
        } catch (Exception e) {
            log.debug("Could not get BinaryElement for active tab", e);
        }

        return element;
    }
}