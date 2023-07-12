/* (C)2020 */
package saps.common.core.storage.exceptions;

public class TaskNotFoundException extends Exception {

  public TaskNotFoundException(String msg) {
    super(msg);
  }

  public TaskNotFoundException(String msg, Throwable t) {
    super(msg, t);
  }
}
