package org.misq.grpc;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;
import lombok.extern.slf4j.Slf4j;
import org.misq.api.CoreApi;

import javax.inject.Singleton;
import java.io.IOException;
import java.io.UncheckedIOException;

@Singleton
@Slf4j
public class GrpcServer {

    // Use grpcurl to test endpoints.
    // https://github.com/grpc/grpc-java/blob/master/documentation/server-reflection-tutorial.md
    // https://offensivedefence.co.uk/posts/grpc-attack-surface
    // Examples:
    // $ grpcurl --plaintext   localhost:9999 list
    //      grpc.reflection.v1alpha.ServerReflection
    //      io.misq.protobuffer.GetVersion
    //      io.misq.protobuffer.Help
    //      io.misq.protobuffer.Wallets
    //
    // $ grpcurl --plaintext   localhost:9999 grpc.proto.Wallets/GetBalance
    // $ grpcurl --plaintext   localhost:9999 grpc.proto.Help/GetMethodHelp
    // $ grpcurl --plaintext   localhost:9999 grpc.proto.P2P/GetPeers
    // $ grpcurl --plaintext   localhost:9999 grpc.proto.GetVersion/GetVersion
    // Describe services
    // $ grpcurl --plaintext   localhost:9999 describe grpc.proto.P2P
    // $ grpcurl --plaintext   localhost:9999 describe grpc.proto.Wallets

    private final CoreApi coreApi;
    private final Server server;

    public GrpcServer(CoreApi coreApi) {
        this.coreApi = coreApi;
        this.server = ServerBuilder.forPort(9999)
                .addService(ProtoReflectionService.newInstance())
                .addService(new GrpcHelpService(coreApi))
                .addService(new GrpcP2PService(coreApi))
                .addService(new GrpcVersionService(coreApi))
                .addService(new GrpcWalletsService(coreApi))
                // .intercept(new PasswordAuthInterceptor())
                .build();
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
