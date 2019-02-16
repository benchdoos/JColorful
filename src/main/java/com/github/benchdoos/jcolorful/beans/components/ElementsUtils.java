package com.github.benchdoos.jcolorful.beans.components;

import com.github.benchdoos.jcolorful.core.ElementConstants;
import com.github.benchdoos.jcolorful.utils.Logging;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

public class ElementsUtils {
    private static final Logger log = LogManager.getLogger(Logging.getCurrentClassName());

    public static BinaryElement getBinary(JsonObject object, String tableHead) {
        final JsonElement headElement = object.get(tableHead);
        return getBinaryElement(headElement);
    }

    public static BinaryElement getBinary(JsonObject object) {
        return getBinaryElement(object);
    }

    private static BinaryElement getBinaryElement(JsonElement headElement) {
        if (headElement != null) {
            BinaryElement binaryElement = new BinaryElementImpl();
            final JsonObject asJsonObject = headElement.getAsJsonObject();
            if (asJsonObject != null) {
                JsonElement background = asJsonObject.get(ElementConstants.BACKGROUND);
                if (background != null) {
                    binaryElement.setBackgroundColor(Color.decode(background.getAsString()));
                }

                JsonElement foreground = asJsonObject.get(ElementConstants.FOREGROUND);
                if (foreground != null) {
                    binaryElement.setForegroundColor(Color.decode(foreground.getAsString()));
                }
            }
            return binaryElement;
        }
        return null;
    }

    public static RowAbleElement getRowAbleElement(JsonObject object) {
        RowAbleElement element = new RowAbleElementImpl();
        try {
            BinaryElement row = ElementsUtils.getBinary(object, ElementConstants.ROW);
            element.setRow(row);
        } catch (Exception e) {
            log.warn("Could not get row for object", e);
        }

        try {
            BinaryElement selectedRow = ElementsUtils.getBinary(object, ElementConstants.SELECTED_ROW);
            element.setSelectedRow(selectedRow);
        } catch (Exception e) {
            log.warn("Could not get selected row for object", e);
        }
        return element;
    }

    public static Object getRowAbleElement(Object element, JsonObject jsonObject) {
        if (element instanceof RowAbleElement) {
            RowAbleElement ableElement = ((RowAbleElement) element);
            final RowAbleElement rowAbleElement = ElementsUtils.getRowAbleElement(jsonObject);
            if (rowAbleElement != null) {
                ableElement.setRow(rowAbleElement.getRow());
                ableElement.setSelectedRow(rowAbleElement.getSelectedRow());
            }
            return ableElement;
        } else return element;
    }
}
