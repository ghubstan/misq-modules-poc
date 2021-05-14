package org.misq.application;

import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.misq.api.ApiDependencyModule;
import org.misq.api.CoreApi;
import org.misq.grpc.GrpcServer;
import org.misq.web.server.WebServer;

@Slf4j
public class ApplicationMain {

    // Asks user if he wants to download & run web server or grpc server (or both),
    // reads reply from cmd line, downloads and dynamically loads modules (I hope).

    @Nullable
    private WebServer webServer;

    @Nullable
    private GrpcServer grpcServer;

    public ApplicationMain() {
    }

    public void start(CoreApi coreApi) {
        log.info("Starting web server...");
        webServer = new WebServer(coreApi);
        webServer.start();

        log.info("Starting grpc server...");
        grpcServer = new GrpcServer(coreApi);
        grpcServer.start();


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                shutdown();
            } catch (Exception ex) {
                log.error("", ex);
            }
        }));

    }

    public void shutdown() {
        if (webServer != null) {
            try {
                log.info("Shutting down web server...");
                webServer.shutdown();
            } catch (Exception ex) {
                log.error("", ex);
            }
        }
        if (grpcServer != null) {
            try {
                log.info("Shutting down grpc server...");
                grpcServer.shutdown();
            } catch (Exception ex) {
                log.error("", ex);
            }
        }
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ApiDependencyModule());
        ApplicationMain daemon = injector.getInstance(ApplicationMain.class);
        daemon.start(injector.getInstance(CoreApi.class));
    }
}