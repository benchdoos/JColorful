package com.github.benchdoos.beans;

import com.github.benchdoos.beans.components.*;
import com.github.benchdoos.core.AWTConstants;
import com.github.benchdoos.core.ModelConstants;
import com.github.benchdoos.serializers.*;
import com.github.benchdoos.utils.ValidateController;
import com.google.gson.*;

public class ThemeBean implements Theme {
    private String name;
    private String author;
    private int version;
    private final String content;
    private BinaryElement commonComponent;
    private BinaryElement buttonElement;
    private JTextComponentElement textComponentElement;
    private JTabbedPaneElement tabbedPaneElement;
    private JTableElement tableElement;
    private JProgressBarElement progressBarElement;
    private BinaryElement checkBoxElement;
    private BinaryElement radioButtonElement;

    public ThemeBean(String jsonContent) {
        this.content = jsonContent;
        ValidateController controller = new ValidateController();
        if (!controller.validate(jsonContent)) {
            throw new IllegalArgumentException("JSON is not valid");
        }


        JsonObject rootElement = new JsonParser().parse(jsonContent).getAsJsonObject();
        JsonArray array = rootElement.getAsJsonArray(ModelConstants.THEME);


        final Gson gson = createGson();

        fillInfo();

        initTheme(array, gson);
    }

    private void applyTheme(JsonArray array, Gson gson) {
        for (int i = 1; i < array.size(); i++) {
            final JsonElement jsonElement = array.get(i);
            JsonObject object = (JsonObject) jsonElement;
            final JsonElement element = object.get(ModelConstants.OBJECT_TYPE);

            if (element.getAsString().equalsIgnoreCase(AWTConstants.J_TEXT_COMPONENT)) {
                textComponentElement = gson.fromJson(jsonElement, JTextComponentElement.class);
            }

            if (element.getAsString().equalsIgnoreCase(AWTConstants.J_BUTTON)) {
                buttonElement = gson.fromJson(jsonElement, BinaryElement.class);
            }

            if (element.getAsString().equalsIgnoreCase(AWTConstants.J_CHECKBOX)) {
                checkBoxElement = gson.fromJson(jsonElement, BinaryElement.class);
            }

            if (element.getAsString().equalsIgnoreCase(AWTConstants.J_RADIOBUTTON)) {
                radioButtonElement = gson.fromJson(jsonElement, BinaryElement.class);
            }
            if (element.getAsString().equalsIgnoreCase(AWTConstants.J_TABBED_PANE)) {
                tabbedPaneElement = gson.fromJson(jsonElement, JTabbedPaneElement.class);
            }

            if (element.getAsString().equalsIgnoreCase(AWTConstants.J_TABLE)) {
                tableElement = gson.fromJson(jsonElement, JTableElement.class);
            }

            if (element.getAsString().equalsIgnoreCase(AWTConstants.J_PROGRESS_BAR)) {
                progressBarElement = gson.fromJson(jsonElement, JProgressBarElement.class);
            }
        }
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

    public String getAuthor() {
        return author;
    }

    @Override
    public BinaryElement getCheckBoxElement() {
        return checkBoxElement;
    }

    public BinaryElement getRadioButtonElement() {
        return radioButtonElement;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BinaryElement getButtonElement() {
        return buttonElement;
    }

    public BinaryElement getCommonComponent() {
        return this.commonComponent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JProgressBarElement getProgressBarElement() {
        return progressBarElement;
    }

    public JTabbedPaneElement getTabbedPaneElement() {
        return tabbedPaneElement;
    }

    public JTableElement getTableElement() {
        return tableElement;
    }

    public JTextComponentElement getTextComponentElement() {
        return this.textComponentElement;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    private void initTheme(JsonArray array, Gson gson) {

        commonComponent = gson.fromJson(array.get(0), BinaryElement.class);

        applyTheme(array, gson);

    }

    private Gson createGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(BinaryElement.class, new BinaryElementDeserializer());
        builder.registerTypeAdapter(JTextComponentElement.class, new JTextComponentDeserializer());
        builder.registerTypeAdapter(JTabbedPaneElement.class, new JTabbedPaneDeserializer());
        builder.registerTypeAdapter(JTableElement.class, new JTableDeserializer());
        builder.registerTypeAdapter(JProgressBarElement.class, new JProgressBarDeserializer());
        return builder.create();
    }

    @Override
    public String toString() {
        return "ThemeBean{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", version=" + version +
                '}';
    }
}
