module org.misq.api {

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

    exports org.misq.api;
}
