package org.misq.grpc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GrpcServer {

    public GrpcServer() {
    }

    public void start() {
        log.info("start");
    }

    public void shutdown() {
        log.info("shutdown");
    }
}
