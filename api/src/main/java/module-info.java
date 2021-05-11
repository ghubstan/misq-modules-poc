module org.misq.api {

    requires java.base;
    requires java.annotation;

    requires org.misq.annotation;
    requires org.misq.logging;
    requires org.misq.utilities;
    requires org.misq.threadmodel;
    requires org.misq.monetary;

    requires com.google.guice;

    exports org.misq.api;
}
