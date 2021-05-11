package org.misq.web.server.handler;


import lombok.extern.slf4j.Slf4j;
import org.misq.api.CoreApi;
import org.misq.web.json.JsonTransform;
import ratpack.handling.Context;
import ratpack.handling.Handler;

@Slf4j
public class GetVersionHandler extends AbstractHandler implements Handler {

    public GetVersionHandler(JsonTransform jsonTransform) {
        super(jsonTransform);
    }

    @Override
    public void handle(Context ctx) throws Exception {
        String version = ctx.get(CoreApi.class).getVersion();
        ctx.render(toJson("version", version));
    }
}
