package com.github.benchdoos.jcolorful.serializers;

import com.github.benchdoos.jcolorful.beans.components.BinaryElement;
import com.github.benchdoos.jcolorful.beans.components.ElementsUtils;
import com.github.benchdoos.jcolorful.beans.components.JTreeElement;
import com.github.benchdoos.jcolorful.beans.components.JTreeElementImpl;
import com.github.benchdoos.jcolorful.utils.Logging;
import com.google.gson.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;

public class JTreeDeserializer implements JsonDeserializer<JTreeElement> {
    private static final Logger log = LogManager.getLogger(Logging.getCurrentClassName());

    @Override
    public JTreeElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        JTreeElement element = new JTreeElementImpl();
        try {
            BinaryElement binary = ElementsUtils.getBinary(object);
            element.setBackgroundColor(binary.getBackgroundColor());
            element.setForegroundColor(binary.getForegroundColor());
        } catch (Exception e) {
            log.warn("Could not get BinaryElement for JTree", e);
        }

        element = ((JTreeElement) ElementsUtils.getRowAbleElement(element, object));
        return element;
    }


}
