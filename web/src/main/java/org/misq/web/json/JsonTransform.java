package org.misq.web.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Singleton;
import org.misq.p2p.PeersResponse;

import java.util.Map;

@Singleton
public class JsonTransform {

    private final Gson gson = new GsonBuilder().serializeNulls().create();

    public String toJson(Map<String, String> map) {
        return gson.toJson(map, String.class);
    }

    public String toJson(PeersResponse peersResponse) {
        return gson.toJson(peersResponse, peersResponse.getClass());
    }
}
