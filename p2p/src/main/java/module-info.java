module org.misq.p2p {
    requires transitive java.annotation;
    requires transitive lombok;
    requires com.google.protobuf;

    requires org.misq.annotation;
    requires org.misq.logging;
    requires org.misq.threadmodel;
    requires org.misq.monetary;

    exports org.misq.p2p;
    exports org.misq.p2p.proto;
}
