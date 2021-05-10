module org.misq.web {

    requires java.base;
    requires java.annotation;

    requires org.misq.annotation;
    requires org.misq.logging;
    requires org.misq.utilities;
    requires org.misq.threadmodel;
    requires org.misq.monetary;
    requires org.misq.api;

    // requires ratpack.core;
    // requires ratpack.base;
    // requires ratpack.exec;
    // requires ratpack.guice;
    // requires ratpack.rx2;

    exports org.misq.web;
}
