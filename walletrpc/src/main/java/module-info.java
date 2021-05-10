module org.misq.walletrpc {

    requires java.base;
    requires java.annotation;

    requires org.checkerframework.checker.qual;
    requires com.google.errorprone.annotations;
    requires com.google.common;
    requires com.google.gson;

    requires lombok;
    requires org.misq.annotation;
    requires org.misq.logging;
    requires org.misq.utilities;
    requires org.misq.threadmodel;
    requires org.misq.monetary;

    exports org.misq.walletrpc;
}
