/* (C)2020 */
package saps.common.core.storage;

import java.io.File;

public class PermanentStorageConstants {

  public static final String INPUTDOWNLOADING_DIR = "inputdownloading";
  public static final String PREPROCESSING_DIR = "preprocessing";
  public static final String PROCESSING_DIR = "processing";

  public static final String SAPS_TASK_STAGE_DIR_PATTERN =
      "%s" + File.separator + "%s" + File.separator + "%s";
}
