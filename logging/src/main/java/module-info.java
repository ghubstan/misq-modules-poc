module org.misq.logging {

    requires java.annotation;

    requires transitive org.slf4j;
    requires transitive ch.qos.logback.classic;
    requires transitive ch.qos.logback.core;

    exports org.misq.logging;
}
