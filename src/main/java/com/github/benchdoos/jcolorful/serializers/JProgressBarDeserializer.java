package com.github.benchdoos.jcolorful.serializers;

import com.github.benchdoos.jcolorful.beans.components.BinaryElement;
import com.github.benchdoos.jcolorful.beans.components.ElementsUtils;
import com.github.benchdoos.jcolorful.beans.components.JProgressBarElement;
import com.github.benchdoos.jcolorful.beans.components.JProgressBarElementImpl;
import com.github.benchdoos.jcolorful.core.ElementConstants;
import com.github.benchdoos.jcolorful.utils.Logging;
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