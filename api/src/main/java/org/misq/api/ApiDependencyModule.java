package org.misq.api;

import com.google.inject.AbstractModule;
import org.misq.p2p.P2PService;

public class ApiDependencyModule extends AbstractModule {

    public void configure() {
        // TODO How can I inject services into CoreApi, instead of using the constructor?
        P2PService p2PService = new P2PService();

        bind(CoreApi.class).toInstance(new CoreApi(p2PService));
    }
}
