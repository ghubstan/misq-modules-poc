module org.misq.api {

    requires java.base;
    requires java.annotation;

    requires com.google.guice;

    requires org.misq.annotation;
    requires org.misq.logging;
    requires org.misq.threadmodel;

    requires transitive org.misq.monetary;
    requires transitive org.misq.p2p;

    exports org.misq.api;
}
