module org.misq.walletrpc.btc {
    requires org.checkerframework.checker.qual;
    requires com.google.errorprone.annotations;
    requires com.google.common;
    requires lombok;

    requires org.misq.libannotation;
    requires org.misq.liblogging;
    requires org.misq.libguava;
    requires org.misq.threadmodel;
    requires org.misq.monetary;
    requires org.misq.walletrpc;

    exports org.misq.walletrpc.btc;
}
