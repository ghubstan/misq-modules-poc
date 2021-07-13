# misq-modules-poc

Investigate if Misq could be based on the Java Platform Module System (JPMS).

https://www.oracle.com/corporate/features/understanding-java-9-modules.html

Strict control of module classpaths would help avoid dependency version conflicts and
build a truly modular system. However, some important 3rd party libraries may never become
JPMS compatible, defeating the purpose of building multi-module, JPMS based applications.

In this POC, I found out that the Java gRPC libs are not and may never conform to JPMS rules.
See https://github.com/grpc/grpc-java/issues/3522.

Even the ubiquitous javax.inject library gave me JPMS problems during this experiment.

The investigation is over, and JPMS has been put aside for now.
