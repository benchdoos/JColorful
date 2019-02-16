package com.github.benchdoos.jcolorful.serializers;

import com.github.benchdoos.jcolorful.beans.components.BinaryElement;
import com.github.benchdoos.jcolorful.beans.components.ElementsUtils;
import com.github.benchdoos.jcolorful.beans.components.JComboBoxElement;
import com.github.benchdoos.jcolorful.beans.components.JComboBoxElementImpl;
import com.github.benchdoos.jcolorful.core.ElementConstants;
import com.github.benchdoos.jcolorful.utils.Logging;
import com.google.gson.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;

public class JComboBoxDeserializer implements JsonDeserializer<JComboBoxElement> {
    private static final Logger log = LogManager.getLogger(Logging.getCurrentClassName());

    @Override
    public JComboBoxElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        JComboBoxElement element = new JComboBoxElementImpl();

        try {
            BinaryElement button = ElementsUtils.getBinary(object, ElementConstants.BUTTON);
            element.setButton(button);
        } catch (Exception e) {
            log.warn("Could not get JComboBoxElement", e);
        }

        element = (JComboBoxElement) ElementsUtils.getRowAbleElement(element, object);

        return element;
    }


}
