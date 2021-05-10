module org.misq.walletrpc.btc {

    requires java.base;
    requires java.annotation;

    requires org.checkerframework.checker.qual;
    requires com.google.errorprone.annotations;
    requires com.google.common;
    requires lombok;

    requires org.misq.annotation;
    requires org.misq.logging;
    requires org.misq.utilities;
    requires org.misq.threadmodel;
    requires org.misq.monetary;
    requires org.misq.walletrpc;

    exports org.misq.walletrpc.btc;
}
