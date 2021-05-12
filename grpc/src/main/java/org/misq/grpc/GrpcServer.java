package org.misq.grpc;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.misq.api.CoreApi;

import javax.inject.Singleton;
import java.io.IOException;
import java.io.UncheckedIOException;

@Singleton
@Slf4j
public class GrpcServer {

    private final CoreApi coreApi;
    private final Server server;

    public GrpcServer(CoreApi coreApi) {
        this.coreApi = coreApi;
        this.server = ServerBuilder.forPort(49998).build();
    }

    public void start() {
        try {
            server.start();
            log.info("Listening on port {}", server.getPort());
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    public void shutdown() {
        log.info("Server shutdown started");
        server.shutdown();
        log.info("Server shutdown complete");
    }

    public static void main(String[] args) {
        // GrpcServer grpcServer = new GrpcServer();
        // grpcServer.start();
    }
}
