package pl.kubiczak.osgi.logging.samples.acl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

  private static final Log LOG = LogFactory.getLog(Activator.class);

  /**
   * Creates log messages with all possible levels while bundle is started
   * with <code>org.apache.commons.logging.Log</code>.
   */
  public void start(BundleContext context) {
    String msg = "bundle " + context.getBundle().getSymbolicName() + " START";
    testLogging(msg);
  }

  /**
   * Creates log messages with all possible levels while bundle is stopped
   * with <code>org.apache.commons.logging.Log</code>.
   */
  public void stop(BundleContext context) {
    String msg = "bundle " + context.getBundle().getSymbolicName() + " STOP";
    testLogging(msg);
  }

  private void testLogging(String msg) {
    LOG.trace("trace: " + msg);
    LOG.debug("debug: " + msg);
    LOG.info("info: " + msg);
    LOG.warn("warn: " + msg);
    LOG.error("error: " + msg);
    LOG.fatal("fatal: " + msg);
  }
}
