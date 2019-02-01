package com.github.benchdoos.utils;

import com.github.benchdoos.beans.components.BinaryElement;
import com.github.benchdoos.serializers.BinaryElementDeserializer;
import com.google.gson.*;

public class ValidateController {
    private final int[] SUPPORTED_JSON_THEMES_VERSIONS = new int[]{1};

    private boolean contains(int value) {
        for (int i = 0; i < SUPPORTED_JSON_THEMES_VERSIONS.length; i++) {
            if (SUPPORTED_JSON_THEMES_VERSIONS[i] == value) {
                return true;
            }
        }
        return false;
    }

    public boolean validate(String content) {
        JsonElement rootElement = new JsonParser().parse(content);
        return validateInformationStructure(rootElement) && validateCommonData(rootElement);
    }

    private boolean validateCommonData(JsonElement rootElement) {
        final JsonObject rootObject = rootElement.getAsJsonObject();
        final JsonArray theme = rootObject.getAsJsonArray("theme");
        final JsonObject commonDataObject = theme.get(0).getAsJsonObject();



        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(BinaryElement.class, new BinaryElementDeserializer());
        Gson gson = builder.create();

        return gson.fromJson(commonDataObject, BinaryElement.class) != null;
    }

    private boolean validateInformationStructure(JsonElement rootElement) {
        final JsonObject rootObject = rootElement.getAsJsonObject();
        final JsonPrimitive typeObject = rootObject.getAsJsonPrimitive("type");
        final JsonPrimitive versionObject = rootObject.getAsJsonPrimitive("version");

        if (typeObject.getAsString().equalsIgnoreCase("JColorfulTheme")) {
            if (contains(versionObject.getAsInt())) {
                return true;
            }
        }
        return false;
    }
}
