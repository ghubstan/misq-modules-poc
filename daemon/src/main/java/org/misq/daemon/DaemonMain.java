package org.misq.daemon;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DaemonMain {

    // Asks user if he wants to download & run web server or grpc server (or both),
    // reads reply from cmd line, downloads and dynamically loads modules (I hope).

    public DaemonMain() {
    }

    public void start() {
        log.info("start");
    }

    public void shutdown() {
        log.info("shutdown");
    }

    public static void main(String[] args) {
        DaemonMain daemonMain = new DaemonMain();
        daemonMain.start();
    }

}