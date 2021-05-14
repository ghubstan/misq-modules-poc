module org.misq.api {
    requires org.misq.libannotation;
    requires org.misq.liblogging;
    requires org.misq.libguice;
    requires org.misq.threadmodel;
    requires transitive org.misq.monetary;
    requires transitive org.misq.p2p;
    exports org.misq.api;
}
