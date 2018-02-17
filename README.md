logging-in-osgi
===============

This is a sample project that shows how logging could be configured for [Felix] framework:

* [SLF4J](#slf4j)
* [JAVA Util Logging](#java-util-logging)
* [Apache Commons Logging](#apache-commons-logging)
* [Apache log4j 1.x](#apache-log4j-1.x)
* [Apache log4j 2.x](#apache-log4j-2.x)
* [OSGi Log Service](#osgi-log-service)

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
This can be done by adding following line in [logback.xml][logback.xml-for-jul]:

```xml
<contextListener class="ch.qos.logback.classic.jul.LevelChangePropagator"/>
```

### Apache Commons Logging

To forward logs from commons-logging to SLF4J we need additional bundle:

* org.slf4j: [jcl-over-slf4j](https://mvnrepository.com/artifact/org.slf4j/jcl-over-slf4j/1.7.25)

### Apache log4j 1.x

Apache announced that [log4j 1.x][log4j-1.x] reached end of life on 2015-08-05.
However there might be still some bundles that use it as logging framework.
Their log messages will be forwarded to SLF4J if we add additional bundle:

* org.slf4j: [log4j-over-slf4j](https://mvnrepository.com/artifact/org.slf4j/log4j-over-slf4j/1.7.25)

### Apache log4j 2.x

There is an issue for OSGi setup with newest version of log4j in OSGi and fileinstall.
Following setup was tested with version 2.8.2.

In order to pass log4j 2.x messages to SLF4J additional two bundles are needed:

* org.apache.logging.log4j: [log4j-api](https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api/2.8.2)
* org.apache.logging.log4j: [log4j-to-slf4j](https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-to-slf4j/2.8.2)

### OSGi Log Service

To forward logs from OSGi Log Service to LSF4J additional bundle is needed:

* org.slf4j: [osgi-over-slf4j](https://mvnrepository.com/artifact/org.slf4j/osgi-over-slf4j/1.7.25)



[Felix]: http://felix.apache.org/downloads.cgi
[SLF4J]: https://www.slf4j.org/
[LOGBack]: https://logback.qos.ch/
[jul-to-slf4j]: https://www.slf4j.org/legacy.html#jul-to-slf4j
[logback.xml-for-jul]: https://github.com/wiiitek/logging-in-osgi/tree/master/samples/samples-jul/src/main/resources/logback.xml#L4
[log4j-1.x]: https://logging.apache.org/log4j/1.2/
