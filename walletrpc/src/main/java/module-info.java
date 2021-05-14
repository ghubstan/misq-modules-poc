module org.misq.walletrpc {
    requires org.checkerframework.checker.qual;
    requires com.google.errorprone.annotations;
    requires com.google.common;
    requires com.google.gson;

    requires lombok;
    requires org.misq.libannotation;
    requires org.misq.liblogging;
    requires org.misq.libguava;

    requires org.misq.threadmodel;
    requires org.misq.monetary;

    exports org.misq.walletrpc;
}
