module org.misq.disq {
    // This module can use :list because it is transitively exported by :utilities
    requires transitive org.misq.utilities;
    exports org.misq.disq;
}
