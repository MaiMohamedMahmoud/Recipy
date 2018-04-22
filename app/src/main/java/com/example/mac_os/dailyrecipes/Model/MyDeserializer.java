package com.example.mac_os.dailyrecipes.Model;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by mac-os on 4/22/18.
 */

public class MyDeserializer<T> implements JsonDeserializer<T> {
    @Override
    public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // Get the "recipes" element from the parsed JSON
        JsonElement recipe = json.getAsJsonObject().get("recipes");

        // Deserialize it. You use a new instance of Gson
        // to this deserializer
        return new Gson().fromJson(recipe, typeOfT);
    }
}
