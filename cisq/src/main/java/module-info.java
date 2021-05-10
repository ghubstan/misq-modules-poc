module org.misq.cisq {

    // Note we do not need a 'requires org.misq.list' directive because it is transitively visible from utilities.
    // This module can use :list because it is transitively exported by :utilities
    requires transitive org.misq.utilities;

    exports org.misq.cisq;
}
