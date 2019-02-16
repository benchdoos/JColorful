package com.github.benchdoos.jcolorful.serializers;

import com.github.benchdoos.jcolorful.beans.components.BinaryElement;
import com.github.benchdoos.jcolorful.beans.components.ElementsUtils;
import com.github.benchdoos.jcolorful.beans.components.JComboBoxElement;
import com.github.benchdoos.jcolorful.beans.components.JComboBoxElementImpl;
import com.github.benchdoos.jcolorful.core.ElementConstants;
import com.google.gson.*;

import java.lang.reflect.Type;

public class JComboBoxDeserializer implements JsonDeserializer<JComboBoxElement> {
    @Override
    public JComboBoxElement deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        JComboBoxElement element = new JComboBoxElementImpl();

        try {
            BinaryElement button = ElementsUtils.getBinary(object, ElementConstants.BUTTON);
            element.setButton(button);
        } catch (Exception e) {
            e.printStackTrace();
        }

        element = (JComboBoxElement) ElementsUtils.getRowAbleElement(element, object);

        return element;
    }


}
