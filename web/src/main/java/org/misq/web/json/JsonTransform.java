package org.misq.web.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Singleton;

import java.util.Map;

@Singleton
public class JsonTransform {

    private final Gson gson = new GsonBuilder().serializeNulls().create();

    public String toJson(Map<String, String> map) {
        return gson.toJson(map, map.getClass());
    }
}
