package pl.kubiczak.osgi.logging.samples.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

  private static final Logger LOG = LogManager.getLogger(Activator.class);

  /**
   * Creates log messages with all possible levels while bundle is started
   * with <code>org.slf4j.Logger</code>.
   */
  public void start(BundleContext context) {
    String msg = "bundle " + context.getBundle().getSymbolicName() + " START";
    testLogging(msg);
  }

  /**
   * Creates log messages with all possible levels while bundle is stopped
   * with <code>org.slf4j.Logger</code>.
   */
  public void stop(BundleContext context) {
    String msg = "bundle " + context.getBundle().getSymbolicName() + " STOP";
    testLogging(msg);
  }

  private void testLogging(String msg) {
    LOG.trace("trace: {}", msg);
    LOG.debug("debug: {}", msg);
    LOG.info("info: {}", msg);
    LOG.warn("warn: {}", msg);
    LOG.error("error: {}", msg);
    LOG.fatal("fatal: {}", msg);
  }
}
