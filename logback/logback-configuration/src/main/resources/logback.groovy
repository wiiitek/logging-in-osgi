//
// Built on Sat Feb 17 17:36:20 CET 2018 by logback-translator
// For more information on configuration files in Groovy
// please see http://logback.qos.ch/manual/groovy.html

// For assistance related to this tool or configuration files
// in general, please contact the logback user mailing list at
//    http://qos.ch/mailman/listinfo/logback-user

// For professional support please see
//   http://www.qos.ch/shop/products/professionalSupport

import ch.qos.logback.classic.encoder.PatternLayoutEncoder

import java.nio.charset.Charset

import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.WARN

scan("2 seconds")
appender("CONSOLE", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%-5level %msg%n%n"
    }
}
appender("FILE", RollingFileAppender) {
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "logs/default_dev_%d{yyyy-MM-dd}.log"
        maxHistory = 30
        totalSizeCap = "300MB"
    }
    encoder(PatternLayoutEncoder) {
        charset = Charset.forName("UTF-8")
        pattern = "%d{HH:mm:ss.SSS} %-5level %logger:%L - %msg%n"
    }
}

logger("pl.kubiczak", DEBUG, ["FILE"], false)

root(WARN, ["FILE"])
