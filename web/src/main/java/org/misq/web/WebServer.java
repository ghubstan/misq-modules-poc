package org.misq.web;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebServer {

    // private RatpackServer ratpackServer;

    public WebServer() {
    }

    public void start() {
        log.info("start");
    }

    public void shutdown() {
        log.info("shutdown");
    }

    public static void main(String[] args) {
        WebServer webServer = new WebServer();
        webServer.start();
    }
}
