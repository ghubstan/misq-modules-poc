package org.misq.web.server.handler;


import lombok.extern.slf4j.Slf4j;
import org.misq.api.CoreApi;
import org.misq.p2p.PeersResponse;
import org.misq.web.json.JsonTransform;
import ratpack.handling.Context;
import ratpack.handling.Handler;

@Slf4j
public class GetPeersHandler extends AbstractHandler implements Handler {

    public GetPeersHandler(JsonTransform jsonTransform) {
        super(jsonTransform);
    }

    @Override
    public void handle(Context ctx) throws Exception {
        PeersResponse peersResponse = ctx.get(CoreApi.class).getPeers();
        ctx.render(toJson(peersResponse));
    }
}
