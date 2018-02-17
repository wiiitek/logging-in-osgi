package pl.kubiczak.osgi.logging.samples.log4j;

import org.apache.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

  private static final Logger LOG = Logger.getLogger(Activator.class);

  /**
   * Creates log messages with all possible levels while bundle is started with
   * <code>org.apache.log4j.Logger</code>.
   */
  public void start(BundleContext context) {
    testLogging(context, "START");
  }

  /**
   * Creates log messages with all possible levels while bundle is stopped with
   * <code>org.apache.log4j.Logger</code>.
   */
  public void stop(BundleContext context) {
    testLogging(context, "STOP");
  }

  private void testLogging(BundleContext context, String action) {
    String msg = "bundle " + context.getBundle().getSymbolicName() + " " + action;

    LOG.trace("trace: " + msg);
    LOG.debug("debug: " + msg);
    LOG.info("info: " + msg);
    LOG.warn("warn: " + msg);
    LOG.error("error: " + msg);
    LOG.fatal("fatal: " + msg);
  }
}
