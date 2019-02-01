package com.github.benchdoos.beans;

import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.beans.components.JTextComponentElement;
import com.github.benchdoos.core.ModelConstants;
import com.github.benchdoos.serializers.BinaryElementDeserializer;
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
       /* JsonObject rootElement = new JsonParser().parse(content).getAsJsonObject();
        final JsonArray theme = rootElement.getAsJsonArray("theme");
        for (int i = 0; i < theme.size(); i++) {
            final JsonObject asJsonObject = theme.get(i).getAsJsonObject();
            //todo add gson parser
            //get all objects and fill all fields
        }*/


        JsonObject rootElement = new JsonParser().parse(content).getAsJsonObject();
        System.out.println("re: " + rootElement);

        JsonArray array = rootElement.getAsJsonArray(ModelConstants.THEME);

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(BinaryElement.class, new BinaryElementDeserializer());
        Gson gson = builder.create();
        BinaryElement common = gson.fromJson(array.get(0), BinaryElement.class);

        commonComponent = common;


    }
}
