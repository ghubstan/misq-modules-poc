module org.misq.liblogging {
    requires java.annotation;
    requires transitive org.slf4j;
    requires transitive ch.qos.logback.classic;
    requires transitive ch.qos.logback.core;
    exports org.misq.liblogging;
}
