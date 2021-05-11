package org.misq.api;

import com.google.inject.AbstractModule;

public class ApiDependencyModule extends AbstractModule {

    public void configure() {
        bind(CoreApi.class).toInstance(new CoreApi());
    }

}
