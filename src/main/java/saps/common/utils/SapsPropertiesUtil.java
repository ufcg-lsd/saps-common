/* (C)2020 */
package saps.common.utils;

import java.util.Properties;
import org.apache.log4j.Logger;

public class SapsPropertiesUtil {

  public static final Logger LOGGER = Logger.getLogger(SapsPropertiesUtil.class);

  public static boolean checkProperties(Properties properties, String[] propertiesSet) {
    if (properties == null) {
      LOGGER.error("Properties arg must not be null.");
      return false;
    }

    for (String property : propertiesSet) {
      if (!properties.containsKey(property) || properties.getProperty(property).isEmpty()) {
        LOGGER.error("Required property " + property + " was not set");
        return false;
      }
    }

    LOGGER.debug("All properties are set");
    return true;
  }
}
