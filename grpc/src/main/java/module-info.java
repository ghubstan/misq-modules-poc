module org.misq.grpc {

    requires java.base;
    requires java.annotation;

    requires org.misq.annotation;
    requires org.misq.logging;
    requires org.misq.utilities;
    requires org.misq.threadmodel;
    requires org.misq.monetary;
    requires org.misq.api;

    exports org.misq.grpc;
}
