package com.github.benchdoos.serializers;

import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.beans.components.ElementsUtils;
import com.github.benchdoos.beans.components.JProgressBarElement;
import com.github.benchdoos.beans.components.JProgressBarElementImpl;
import com.github.benchdoos.core.ElementConstants;
import com.github.benchdoos.utils.Logging;
import com.google.gson.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;

public class JProgressBarDeserializer implements JsonDeserializer<JProgressBarElement> {
    private static final Logger log = LogManager.getLogger(Logging.getCurrentClassName());

    public JProgressBarElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        JProgressBarElement element = new JProgressBarElementImpl();

        try {
            BinaryElement bin = ElementsUtils.getBinary(object);
            element.setForegroundColor(bin.getForegroundColor());
            element.setBackgroundColor(bin.getBackgroundColor());
        } catch (Exception e) {
            log.debug("Can not create BinaryElement for JProgressBarElement", e);
        }

        try {
            BinaryElement string = ElementsUtils.getBinary(object, ElementConstants.STRING_ELEMENT);
            element.setStringElement(string);
        } catch (Exception e) {
            log.debug("Can not create BinaryElement for StringElement", e);
        }

        return element;
    }
}