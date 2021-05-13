package org.misq.web.server;

import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import org.misq.api.CoreApi;
import org.misq.web.server.handler.GetBalanceHandler;
import org.misq.web.server.handler.GetPeersHandler;
import org.misq.web.server.handler.GetVersionHandler;
import ratpack.guice.Guice;
import ratpack.handling.RequestLogger;
import ratpack.rx2.RxRatpack;
import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;

@Slf4j
public class WebServer {

    private RatpackServer ratpackServer;

    private final CoreApi coreApi;

    public WebServer(CoreApi coreApi) {
        this.coreApi = coreApi;
    }

    public void start() {
        log.info("start");
        RxRatpack.initialize();
        try {
            ServerConfig serverConfig = ServerConfig.of(config -> config
                    .port(5050)
                    .findBaseDir()
            );
            this.ratpackServer = RatpackServer.start(server -> server
                    .serverConfig(serverConfig)
                    .registry(Guice.registry(bindings -> bindings.module(WebAppDependencyModule.class).add(CoreApi.class, coreApi)))
                    .handlers(chain -> chain
                            .all(RequestLogger.ncsa())
                            .get("server-error", ctx -> {
                                Observable.<String>error(new IllegalStateException("Server error from observable"))
                                        .subscribe(s -> {
                                        });
                            })
                            // .get("streaming-movies", ctx -> ctx.get(StreamingMoviesHandler.class).handle(ctx))
                            // .get("bidi-streaming-movies", ctx -> ctx.get(BidiStreamingMoviesHandler.class).handle(ctx))
                            .get("balance", ctx -> ctx.get(GetBalanceHandler.class).handle(ctx))
                            .get("peers", ctx -> ctx.get(GetPeersHandler.class).handle(ctx))
                            .get("version", ctx -> ctx.get(GetVersionHandler.class).handle(ctx))
                            .get(ctx -> ctx.render("Welcome to Misq Web"))
                    )
            );

            log.info("Ratpack running... set breakpoint here to check registry bindings.");

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    shutdown();
                } catch (Exception ex) {
                    log.error("", ex);
                }
            }));

        } catch (Exception ex) {
            log.error("", ex);
            throw new RuntimeException(ex);
        }
    }

    public void shutdown() {
        if (ratpackServer.isRunning()) {
            try {
                log.info("shutdown");
                ratpackServer.stop();
            } catch (Exception ex) {
                log.error("Error stopping web server.", ex);
            }
        }
    }
}
