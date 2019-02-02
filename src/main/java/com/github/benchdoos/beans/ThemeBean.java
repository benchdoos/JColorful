package com.github.benchdoos.beans;

import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.beans.components.JTabbedPaneElement;
import com.github.benchdoos.beans.components.JTextComponentElement;
import com.github.benchdoos.core.AWTConstants;
import com.github.benchdoos.core.ModelConstants;
import com.github.benchdoos.serializers.BinaryElementDeserializer;
import com.github.benchdoos.serializers.JTabbedPaneDeserializer;
import com.github.benchdoos.serializers.JTextComponentDeserializer;
import com.github.benchdoos.utils.ValidateController;
import com.google.gson.*;

public class ThemeBean implements Theme {
    private String name;
    private String author;
    private int version;
    private String content;
    private BinaryElement commonComponent;
    private JTextComponentElement textComponentElement;
    private JTabbedPaneElement tabbedPaneElement;

    public ThemeBean(String content) {
        this.content = content;
        ValidateController controller = new ValidateController();
        if (!controller.validate(content)) {
            throw new IllegalArgumentException("JSON is not valid");
        }


        fillInfo();
        parseContent();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    private void fillInfo() {
        JsonObject rootElement = new JsonParser().parse(content).getAsJsonObject();
        System.out.println(rootElement);
        final JsonPrimitive asJsonPrimitive = rootElement.getAsJsonPrimitive(ModelConstants.NAME);
        setAuthor(rootElement.getAsJsonPrimitive(ModelConstants.AUTHOR).getAsString());
        setName(asJsonPrimitive.getAsString());
        setVersion(rootElement.getAsJsonPrimitive(ModelConstants.VERSION).getAsInt());
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    public BinaryElement getCommonComponent() {
        return this.commonComponent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public JTextComponentElement getTextComponentElement() {
        return this.textComponentElement;
    }

    @Override
    public JTabbedPaneElement getTabbedPaneElement() {
        return tabbedPaneElement;
    }

    @Override
    public int getVersion() {
        return version;
    }

    @Override
    public void setVersion(int version) {
        this.version = version;
    }

    private void parseContent() {
        JsonObject rootElement = new JsonParser().parse(content).getAsJsonObject();

        JsonArray array = rootElement.getAsJsonArray(ModelConstants.THEME);

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(BinaryElement.class, new BinaryElementDeserializer());
        builder.registerTypeAdapter(JTextComponentElement.class, new JTextComponentDeserializer());
        builder.registerTypeAdapter(JTabbedPaneElement.class, new JTabbedPaneDeserializer());
        Gson gson = builder.create();

        commonComponent = gson.fromJson(array.get(0), BinaryElement.class);


        for (int i = 1; i < array.size(); i++) {
            final JsonElement jsonElement = array.get(i);
            JsonObject object = (JsonObject) jsonElement;
            final JsonElement element = object.get(ModelConstants.OBJECT_TYPE);

            if (element.getAsString().equalsIgnoreCase(AWTConstants.J_TEXT_COMPONENT)) {
                textComponentElement = gson.fromJson(jsonElement, JTextComponentElement.class);
            }

            if (element.getAsString().equalsIgnoreCase(AWTConstants.J_TABBED_PANE)) {
                tabbedPaneElement = gson.fromJson(jsonElement, JTabbedPaneElement.class);
            }
        }
    }
}
