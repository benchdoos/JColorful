package com.github.benchdoos.jcolorful.serializers;

import com.github.benchdoos.jcolorful.beans.components.BinaryElement;
import com.github.benchdoos.jcolorful.beans.components.ElementsUtils;
import com.github.benchdoos.jcolorful.beans.components.JTableElement;
import com.github.benchdoos.jcolorful.beans.components.JTableElementImpl;
import com.github.benchdoos.jcolorful.core.ElementConstants;
import com.github.benchdoos.jcolorful.utils.Logging;
import com.google.gson.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Type;

public class JTableDeserializer implements JsonDeserializer<JTableElement> {
    private static final Logger log = LogManager.getLogger(Logging.getCurrentClassName());

    @Override
    public JTableElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        JTableElement element = new JTableElementImpl();

        try {
            BinaryElement head = ElementsUtils.getBinary(object, ElementConstants.HEAD);
            element.setHeader(head);
        } catch (Exception e) {
            log.warn("Could not get BinaryElement for head", e);
        }

        try {
            BinaryElement row = ElementsUtils.getBinary(object, ElementConstants.ROW);
            if (row != null) {
                element.setRow(row);
            }
        } catch (Exception e) {
            log.warn("Could not get BinaryElement for row", e);
        }

        try {
            BinaryElement selectedRow = ElementsUtils.getBinary(object, ElementConstants.SELECTED_ROW);
            if (selectedRow != null) {
                element.setSelectedRow(selectedRow);
            }
        } catch (Exception e) {
            log.warn("Could not get BinaryElement for selected row", e);
        }

        try {
            BinaryElement editor = ElementsUtils.getBinary(object, ElementConstants.EDITOR);
            if (editor != null) {
                element.setEditor(editor);
            }
        } catch (Exception e) {
            log.warn("Could not get BinaryElement for editor", e);
        }


        return element;
    }


}
