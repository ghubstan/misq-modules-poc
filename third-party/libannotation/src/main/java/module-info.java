module org.misq.libannotation {
    requires transitive java.annotation;
    requires transitive org.checkerframework.checker.qual;
    requires transitive com.google.errorprone.annotations;
    requires transitive lombok;
    exports org.misq.libannotation;
}
