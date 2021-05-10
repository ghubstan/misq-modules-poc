module org.misq.daemon {

    requires java.base;
    requires java.annotation;

    requires org.checkerframework.checker.qual;
    requires com.google.errorprone.annotations;
    requires com.google.common;

    requires org.slf4j;
    requires ch.qos.logback.classic;
    requires ch.qos.logback.core;
    requires lombok;

    requires transitive org.misq.threadmodel;
    requires transitive org.misq.monetary;
    requires transitive org.misq.api;    

    exports org.misq.daemon;
}
