package pl.kubiczak.osgi.logging.jul.configuration.bundle;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.bridge.SLF4JBridgeHandler;

public class Activator implements BundleActivator {

  /**
   * Installs slf4j handler for java.util.logging.
   * Sets JUL log level to ALL in order to allow for logback configuration.
   */
  public void start(BundleContext bundleContext) {
    // reconfiguring JUL to work with slf4j
    // see also http://stackoverflow.com/questions/9117030/jul-to-slf4j-bridge
    LogManager.getLogManager().reset();

    SLF4JBridgeHandler.removeHandlersForRootLogger();
    SLF4JBridgeHandler.install();

    // sets the rot Logger to finest level as Slf4J dos not change the settings for JUL framework
    // see also http://osdir.com/ml/java-logback-user/2009-06/msg00033.html
    Logger rootLogger = Logger.getLogger("");
    rootLogger.setLevel(Level.ALL);

    Logger activatorLogger = Logger.getLogger(getClass().getCanonicalName());
    activatorLogger.info("JUL handlers replaced by SLF4JBridgeHandler");
  }

  public void stop(BundleContext bundleContext) {
  }
}
