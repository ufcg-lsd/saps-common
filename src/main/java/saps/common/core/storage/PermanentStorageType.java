/* (C)2020 */
package saps.common.core.storage;

public enum PermanentStorageType {
  NFS("nfs");

  private final String type;

  PermanentStorageType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
