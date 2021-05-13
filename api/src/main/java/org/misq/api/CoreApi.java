package org.misq.api;

import lombok.extern.slf4j.Slf4j;
import org.misq.p2p.P2PService;
import org.misq.p2p.PeersResponse;

@Slf4j
public class CoreApi {

    private final P2PService p2PService;

    // TODO How to @Inject?
    public CoreApi(P2PService p2PService) {
        this.p2PService = p2PService;
    }

    public PeersResponse getPeers() {
        PeersResponse peersResponse = p2PService.getPeers();

        log.info(peersResponse.toString());
        log.info("Demonstrate modularized protobuf def: {}", peersResponse.toProtoMessage());

        return peersResponse;
    }

    public long getBalance() {
        return 100000000;
    }

    public String getHelp() {
        return "What?";
    }

    public String getVersion() {
        return "0.0.1-SNAPSHOT";
    }
}
