package com.github.benchdoos.jcolorful.serializers;

import com.github.benchdoos.jcolorful.beans.components.BinaryElement;
import com.github.benchdoos.jcolorful.beans.components.ElementsUtils;
import com.github.benchdoos.jcolorful.beans.components.JTextComponentElement;
import com.github.benchdoos.jcolorful.beans.components.JTextComponentElementImpl;
import com.github.benchdoos.jcolorful.core.ElementConstants;
import com.github.benchdoos.jcolorful.utils.Logging;
import com.google.gson.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.lang.reflect.Type;

public class JTextComponentDeserializer implements JsonDeserializer<JTextComponentElement> {
    private static final Logger log = LogManager.getLogger(Logging.getCurrentClassName());

    public JTextComponentElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        JTextComponentElement element = new JTextComponentElementImpl();

        try {
            BinaryElement binary = ElementsUtils.getBinary(object);
            element.setBackgroundColor(binary.getBackgroundColor());
            element.setForegroundColor(binary.getForegroundColor());
        } catch (Exception e) {
            log.warn("Could not get BinaryElement for JTextComponentElement", e);
        }


        try {
            final JsonElement caretColor = object.get(ElementConstants.CARET);
            if (caretColor != null) {
                element.setCaretColor(Color.decode(caretColor.getAsString()));
            }
        } catch (Exception e) {
            log.warn("Could not get Caret color", e);
        }

        try {
            final JsonElement selectionElement = object.get(ElementConstants.SELECTION);
            if (selectionElement != null) {
                element.setSelectionColor(Color.decode(selectionElement.getAsString()));
            }
        } catch (NumberFormatException e) {
            log.warn("Could not get Selection color", e);
        }

        return element;
    }
}