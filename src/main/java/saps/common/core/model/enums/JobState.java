/* (C)2020 */
package saps.common.core.model.enums;

import java.util.ArrayList;
import java.util.List;

public enum JobState {
  SUBMITTED("Submitted"),
  FAILED("Failed"),
  CREATED("Created"),
  FINISHED("Finished"),
  RUNNING("Running");
  ;

  private String desc;

  JobState(String desc) {
    this.desc = desc;
  }

  public String value() {
    return this.desc;
  }

  public static JobState create(String desc) throws Exception {
    for (JobState ts : values()) {
      if (ts.value().equals(desc)) {
        return ts;
      }
    }
    throw new Exception("Invalid job state");
  }

  public static JobState getStateFromStr(String stateStr) {
    JobState[] elements = values();
    for (JobState currentState : elements) {
      if (currentState.value().equals(stateStr) || currentState.name().equals(stateStr)) {
        return currentState;
      }
    }
    return null;
  }

  public static List<String> getAllValues() {

    List<String> values = new ArrayList<String>();

    for (JobState currentState : values()) {
      values.add(currentState.name());
    }

    return values;
  }
}
