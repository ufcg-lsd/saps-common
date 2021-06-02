/* (C)2020 */
package saps.common.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** Created by manel on 22/08/16. */
public class ProcessUtil {

  public static String getOutput(Process p) throws IOException {
    try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
      StringBuilder out = new StringBuilder();
      while (true) {
        String line = r.readLine();
        if (line == null) {
          break;
        }
        out.append(line);
      }
      return out.toString();
    }
  }

  public static String getError(Process p) throws IOException {
    try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getErrorStream()))) {
      StringBuilder error = new StringBuilder();
      while (true) {
        String line = r.readLine();
        if (line == null) {
          break;
        }
        error.append(line);
      }
      return error.toString();
    }
  }
}
