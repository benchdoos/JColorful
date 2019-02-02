package com.github.benchdoos.beans;

import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.beans.components.JTextComponentElement;
import com.github.benchdoos.core.AWTConstants;
import com.github.benchdoos.core.ModelConstants;
import com.github.benchdoos.serializers.BinaryElementDeserializer;
import com.github.benchdoos.serializers.JTextComponentDeserializer;
import com.github.benchdoos.utils.ValidateController;
import com.google.gson.*;

public class ThemeBean implements JTheme {

    private String content;
    private BinaryElement commonComponent;
    private JTextComponentElement textComponentElement;

    public ThemeBean(String content) {
        this.content = content;
        ValidateController controller = new ValidateController();
        if (!controller.validate(content)) {
            throw new IllegalArgumentException("JSON is not valid");
        }

        parseContent();
    }

    public BinaryElement getCommonComponent() {
        return this.commonComponent;
    }

    public JTextComponentElement getTextComponentElement() {
        return this.textComponentElement;
    }

    private void parseContent() {
        JsonObject rootElement = new JsonParser().parse(content).getAsJsonObject();

        JsonArray array = rootElement.getAsJsonArray(ModelConstants.THEME);

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(BinaryElement.class, new BinaryElementDeserializer());
        builder.registerTypeAdapter(JTextComponentElement.class, new JTextComponentDeserializer());
        Gson gson = builder.create();

        commonComponent = gson.fromJson(array.get(0), BinaryElement.class);


        for (int i = 1; i < array.size(); i++) {
            final JsonElement jsonElement = array.get(i);
            System.out.println(":" + jsonElement);
            JsonObject object = (JsonObject) jsonElement;
            final JsonElement element = object.get(ModelConstants.OBJECT_TYPE);

            if (element.getAsString().equalsIgnoreCase(AWTConstants.J_TEXT_COMPONENT)) {
                textComponentElement = gson.fromJson(jsonElement, JTextComponentElement.class);
            }
        }


    }
}
