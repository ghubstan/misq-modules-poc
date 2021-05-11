package org.misq.daemon;

import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.extern.slf4j.Slf4j;
import org.misq.api.ApiDependencyModule;
import org.misq.api.CoreApi;
import org.misq.web.server.WebServer;

@Slf4j
public class DaemonMain {

    // Asks user if he wants to download & run web server or grpc server (or both),
    // reads reply from cmd line, downloads and dynamically loads modules (I hope).

    public DaemonMain() {
    }

    public void start(CoreApi coreApi) {
        log.info("Starting web server...");

        WebServer webServer = new WebServer(coreApi);
        webServer.start();


        // log.info("Starting grpc server...");
    }

    public void shutdown() {
        log.info("shutdown");
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ApiDependencyModule());

        // Now just bootstrap the application and you're done
        DaemonMain daemon = injector.getInstance(DaemonMain.class);
        daemon.start(injector.getInstance(CoreApi.class));

        // DaemonMain daemonMain = new DaemonMain();
        // daemonMain.start();
    }

}