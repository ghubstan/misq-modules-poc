package org.misq.web.server.handler;

import lombok.extern.slf4j.Slf4j;
import org.misq.p2p.PeersResponse;
import org.misq.web.json.JsonTransform;
import ratpack.handling.Handler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public abstract class AbstractHandler implements Handler {

    private final JsonTransform jsonTransform;

    public AbstractHandler(JsonTransform jsonTransform) {
        this.jsonTransform = jsonTransform;
    }

    protected Map<String, String> toMap(String key, Object value) {
        Map<String, String> map = new HashMap<>();
        map.put(key, String.valueOf(value));
        return map;
    }

    protected String toJson(Map<String, String> map) {
        return jsonTransform.toJson(map);
    }

    protected String toJson(String key, Object value) {
        return jsonTransform.toJson(toMap(key, value));
    }

    protected String toJson(PeersResponse peersResponse) {
        return jsonTransform.toJson(peersResponse);
    }

    protected String toJson(Throwable throwable) {
        Map<String, String> map = toMap("error", throwable.getClass().getCanonicalName());
        map.put("message", throwable.getMessage());
        return jsonTransform.toJson(map);
    }
}
