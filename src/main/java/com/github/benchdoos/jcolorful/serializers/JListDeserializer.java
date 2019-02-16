package com.github.benchdoos.jcolorful.serializers;

import com.github.benchdoos.jcolorful.beans.components.ElementsUtils;
import com.github.benchdoos.jcolorful.beans.components.JListElement;
import com.github.benchdoos.jcolorful.beans.components.JListElementImpl;
import com.github.benchdoos.jcolorful.utils.Logging;
import com.google.gson.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;

public class JListDeserializer implements JsonDeserializer<JListElement> {
    private static final Logger log = LogManager.getLogger(Logging.getCurrentClassName());

    @Override
    public JListElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        JListElement element = null;
        try {
            element = new JListElementImpl();
            element = ((JListElement) ElementsUtils.getRowAbleElement(element, object));
        } catch (Exception e) {
            log.warn("Could not get JListElement", e);
        }

        return element;
    }


}
