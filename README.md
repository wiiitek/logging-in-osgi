logging-in-osgi
===============

This is a sample project that shows how logging could be configured for [Felix] framework:

* [SLF4J](#slf4j)
* [JUL](#java-util-logging)

### SLF4J

Our logging uses [SLF4J:1.7.25][SLF4J] with [LOGBack:1.2.3][LOGBack] . For simple usage we need:

* org.slf4j: [slf4j-api](https://mvnrepository.com/artifact/org.slf4j/slf4j-api/1.7.25)
* ch.qos.logback: [logback-classic](https://mvnrepository.com/artifact/ch.qos.logback/logback-classic/1.2.3)
* ch.qos.logback: [logback-core](https://mvnrepository.com/artifact/ch.qos.logback/logback-core/1.2.3)

We could provide LOGBack configuration file with additional parameter:

```commandline
java -Dlogback.configurationFile=logback.xml -jar bin\felix.jar
```

Target project requires dependency to `slf4j-api` only.

### JAVA util logging

In order to forward JAVA util logging to SLF4J two more things are needed:

1. org.slf4j: [jul-to-slf4j](https://mvnrepository.com/artifact/org.slf4j/jul-to-slf4j/1.7.25)
2. Additional configuration for JAVA logging over SLF4J (see *jul-configuration* module)

Please notice that for production purposes the [LevelChangePropagator][jul-to-slf4j] should be installed!



[Felix]: http://felix.apache.org/downloads.cgi
[SLF4J]: https://www.slf4j.org/
[LOGBack]: https://logback.qos.ch/
[jul-to-slf4j]: https://www.slf4j.org/legacy.html#jul-to-slf4j
