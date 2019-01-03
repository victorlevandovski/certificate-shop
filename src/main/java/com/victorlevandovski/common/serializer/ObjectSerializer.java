package com.victorlevandovski.common.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ObjectSerializer {

    private static ObjectSerializer instance;
    private Gson gson;

    public static synchronized ObjectSerializer instance() {
        if (ObjectSerializer.instance == null) {
            ObjectSerializer.instance = new ObjectSerializer();
        }

        return ObjectSerializer.instance;
    }

    private ObjectSerializer() {
        this.gson = new GsonBuilder().create();
    }

    public String serialize(Object object) {
        return this.gson.toJson(object);
    }
}
