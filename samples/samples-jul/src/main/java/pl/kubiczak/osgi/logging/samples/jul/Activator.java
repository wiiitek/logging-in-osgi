package pl.kubiczak.osgi.logging.samples.jul;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

  private static final Logger LOG = Logger.getLogger(Activator.class.getName());

  /**
   * Creates log messages with all possible levels while bundle is started
   * with <code>java.util.logging.Logger</code>.
   */
  public void start(BundleContext context) {
    String msg = "bundle " + context.getBundle().getSymbolicName() + " START";
    testLogging(msg);
  }

  /**
   * Creates log messages with all possible levels while bundle is stopped
   * with <code>java.util.logging.Logger</code>.
   */
  public void stop(BundleContext context) {
    String msg = "bundle " + context.getBundle().getSymbolicName() + " STOP";
    testLogging(msg);
  }

  private void testLogging(String msg) {
    // using log method as it supports message parameters
    LOG.log(Level.FINEST, "finest: {0}", msg);
    LOG.log(Level.FINER, "finer: {0}", msg);
    LOG.log(Level.FINE, "fine: {0}", msg);
    LOG.log(Level.INFO, "info: {0}", msg);
    LOG.log(Level.WARNING, "warning: {0}", msg);
    LOG.log(Level.SEVERE, "severe: {0}", msg);
  }
}
