package org.misq.web.server;

import com.google.inject.AbstractModule;
import org.misq.web.json.JsonTransform;
import org.misq.web.server.handler.*;
import ratpack.error.ClientErrorHandler;
import ratpack.error.ServerErrorHandler;

public class WebAppDependencyModule extends AbstractModule {

    public void configure() {
        JsonTransform jsonTransform = new JsonTransform();
        bind(JsonTransform.class).toInstance(jsonTransform);

        // error handlers
        bind(ServerErrorHandler.class).toInstance(new MisqServerErrorHandler(jsonTransform));
        bind(ClientErrorHandler.class).toInstance(new MisqClientErrorHandler(jsonTransform));

        // api handlers
        bind(GetBalanceHandler.class).toInstance(new GetBalanceHandler(jsonTransform));
        bind(GetPeersHandler.class).toInstance(new GetPeersHandler(jsonTransform));
        bind(GetVersionHandler.class).toInstance(new GetVersionHandler(jsonTransform));
    }

}
