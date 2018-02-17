package pl.kubiczak.osgi.logging.samples.logservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

  private ServiceTracker logServiceTracker;

  /**
   * Creates log messages with all possible levels while bundle is started
   * with <code>org.osgi.service.log.LogService</code>.
   * Service is retrieved with <code>ServiceTracker</code>.
   */
  public void start(BundleContext context) {
    // create a tracker and track the log service
    logServiceTracker = new ServiceTracker(context, LogService.class.getName(), null);
    logServiceTracker.open();
    // grab the service
    LogService logService = (LogService) logServiceTracker.getService();
    if (logService != null) {
      String msg = "bundle " + context.getBundle().getSymbolicName() + " START";
      testLogging(logService, msg);
    }
  }

  /**
   * Creates log messages with all possible levels while bundle is stopped
   * with <code>org.osgi.service.log.LogService</code>.
   * Service is retrieved with <code>ServiceTracker</code>.
   */
  public void stop(BundleContext context) {
    LogService logService = (LogService) logServiceTracker.getService();
    if (logService != null) {
      String msg = "bundle " + context.getBundle().getSymbolicName() + " STOP";
      testLogging(logService, msg);
    }
    // close the service tracker
    logServiceTracker.close();
    logServiceTracker = null;
  }

  private void testLogging(LogService logService, String msg) {
    logService.log(LogService.LOG_DEBUG, ": " + msg);
    logService.log(LogService.LOG_INFO, ": " + msg);
    logService.log(LogService.LOG_WARNING, ": " + msg);
    logService.log(LogService.LOG_ERROR, ": " + msg);
  }
}
