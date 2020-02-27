logging-in-osgi
===============

This is a sample project that shows how logging could be configured for [Felix] framework.
Third party bundles may be using various logging frameworks.
We want to configure the log messages in one place.

* [Logging APIs](#logging-apis)
* [Logging Implementations](#logging-implementations)

How to Run this project
-----------------------

1. Download Apache felix and required dependencies into `${project.build.directory}` folder (`./target`):

    ```commandline
    mvn clean package -Pdeps,felix
    ```

1. Unzip Apache felix framework into `felix` folder.
1. Copy jars from `./target/deps` folder into `felix/bundle/` folder.
1. Copy JUL configuration bundle (`jul-configuration-0.1.0-SNAPSHOT.jar`) into `felix/bundle/` folder.
1. Copy sample logging bundles into `felix/bundle/` folder.
1. Copy `logback.xml` configuration file into `felix/` folder.
1. Run Felix with `java -Dlogback.configurationFile=logback.xml -jar bin\felix.jar`

You can now find sample logs in `felix/logs` folder.

Logging APIs
------------

* [SLF4J](#slf4j)
* [JAVA Util Logging](#java-util-logging)
* [Apache Commons Logging](#apache-commons-logging)
* [Apache log4j 1.x](#apache-log4j-1.x)
* [Apache log4j 2.x](#apache-log4j-2.x)
* [OSGi Log Service](#osgi-log-service)

### SLF4J

Our logging uses [SLF4J:1.7.30][SLF4J] with [LOGBack:1.2.3][LOGBack] . For simple usage we need:

* org.slf4j: [slf4j-api](https://mvnrepository.com/artifact/org.slf4j/slf4j-api/1.7.30)
* ch.qos.logback: [logback-classic](https://mvnrepository.com/artifact/ch.qos.logback/logback-classic/1.2.3)
* ch.qos.logback: [logback-core](https://mvnrepository.com/artifact/ch.qos.logback/logback-core/1.2.3)

We could provide LOGBack configuration file with additional parameter:

```commandline
java -Dlogback.configurationFile=logback.xml -jar bin\felix.jar
```

Target project requires dependency to `slf4j-api` only.

### JAVA Util Logging

In order to forward JAVA util logging to SLF4J two more things are needed:

1. org.slf4j: [jul-to-slf4j](https://mvnrepository.com/artifact/org.slf4j/jul-to-slf4j/1.7.30)
2. Additional configuration for JAVA logging over SLF4J (see *jul-configuration* module)

Please notice that for production purposes the [LevelChangePropagator][jul-to-slf4j] should be installed!
This can be done by adding following line in [logback.xml][logback.xml-example]:

```xml
<contextListener class="ch.qos.logback.classic.jul.LevelChangePropagator"/>
```

### Apache Commons Logging

To forward logs from commons-logging to SLF4J we need additional bundle:

* org.slf4j: [jcl-over-slf4j](https://mvnrepository.com/artifact/org.slf4j/jcl-over-slf4j/1.7.30)

### Apache log4j 1.x

Apache announced that [log4j 1.x][log4j-1.x] reached end of life on 2015-08-05.
However there might be still some bundles that use it as logging framework.
Their log messages will be forwarded to SLF4J if we add additional bundle:

* org.slf4j: [log4j-over-slf4j](https://mvnrepository.com/artifact/org.slf4j/log4j-over-slf4j/1.7.30)

### Apache log4j 2.x

There is an issue for OSGi setup with newest version of log4j in OSGi and fileinstall.
Following setup was tested with version 2.13.0.

In order to pass log4j 2.x messages to SLF4J additional two bundles are needed:

* org.apache.logging.log4j: [log4j-api](https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api/2.13.0)
* org.apache.logging.log4j: [log4j-to-slf4j](https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-to-slf4j/2.13.0)

### OSGi Log Service

To forward logs from OSGi Log Service to LSF4J additional bundle is needed:

* org.slf4j: [osgi-over-slf4j](https://mvnrepository.com/artifact/org.slf4j/osgi-over-slf4j/1.7.30)

Logging Implementations
-----------------------

### Logback Groovy Configuration

This project uses LOGBack for log messages.
It is possible to keep LOGBack configuration in [groovy][logback.groovy-example] file.
There is [online translator][logback-xml2groovy] that converts XML configuration to Groovy.
To read this configuration LOGBack needs additional bundle:

* org.codehaus.groovy: [groovy](https://mvnrepository.com/artifact/org.codehaus.groovy/groovy)





[Felix]: http://felix.apache.org/downloads.cgi
[SLF4J]: https://www.slf4j.org/
[LOGBack]: https://logback.qos.ch/
[jul-to-slf4j]: https://www.slf4j.org/legacy.html#jul-to-slf4j
[logback.xml-example]: https://github.com/wiiitek/logging-in-osgi/tree/master/logback/logback-configuration/src/main/resources/logback.xml#L4
[logback.groovy-example]: https://github.com/wiiitek/logging-in-osgi/tree/master/logback/logback-configuration/src/main/resources/logback.groovy
[log4j-1.x]: https://logging.apache.org/log4j/1.2/
[logback-xml2groovy]: https://logback.qos.ch/translator/asGroovy.html
