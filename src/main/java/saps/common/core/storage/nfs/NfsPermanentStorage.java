/* (C)2020 */
package saps.common.core.storage.nfs;

import static saps.common.core.storage.PermanentStorageConstants.INPUTDOWNLOADING_DIR;
import static saps.common.core.storage.PermanentStorageConstants.PREPROCESSING_DIR;
import static saps.common.core.storage.PermanentStorageConstants.PROCESSING_DIR;
import static saps.common.core.storage.PermanentStorageConstants.SAPS_TASK_STAGE_DIR_PATTERN;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import saps.common.core.model.SapsImage;
import saps.common.core.model.enums.ImageTaskState;
import saps.common.core.storage.AccessLink;
import saps.common.core.storage.PermanentStorage;
import saps.common.core.storage.exceptions.InvalidPropertyException;
import saps.common.utils.SapsPropertiesConstants;
import saps.common.utils.SapsPropertiesUtil;

public class NfsPermanentStorage implements PermanentStorage {

  public static final Logger LOGGER = Logger.getLogger(NfsPermanentStorage.class);
  public static final String NFS_STORAGE_TASK_DIR_PATTERN =
      "%s" + File.separator + "%s" + File.separator + "%s";
  public static final String NFS_STORAGE_TASK_URL_PATTERN = "%s" + File.separator + "%s";

  private final String nfsTempStoragePath;
  private final String nfsPermanentStoragePath;
  private final String tasksDirName;
  private final String debugTasksDirName;
  private final String baseUrl;
  private final boolean debugMode;

  public NfsPermanentStorage(Properties properties) throws InvalidPropertyException {
    if (!checkProperties(properties))
      throw new InvalidPropertyException(
          "Error on validate the file. Missing properties for start Nfs Permanent Storage.");

    this.nfsTempStoragePath =
        properties.getProperty(SapsPropertiesConstants.SAPS_TEMP_STORAGE_PATH);
    this.nfsPermanentStoragePath =
        properties.getProperty(SapsPropertiesConstants.FS_PERMANENT_STORAGE_PATH);
    this.tasksDirName = properties.getProperty(SapsPropertiesConstants.PERMANENT_STORAGE_TASKS_DIR);
    this.baseUrl = properties.getProperty(SapsPropertiesConstants.PERMANENT_STORAGE_BASE_URL);

    this.debugMode =
        properties.containsKey(SapsPropertiesConstants.SAPS_DEBUG_MODE)
            && properties
                .getProperty(SapsPropertiesConstants.SAPS_DEBUG_MODE)
                .toLowerCase()
                .equals("true");

    if (this.debugMode && !checkPropertiesDebugMode(properties))
      throw new InvalidPropertyException(
          "Error on validate the file. Missing properties for start Saps Controller.");

    this.debugTasksDirName =
        (this.debugMode)
            ? properties.getProperty(SapsPropertiesConstants.PERMANENT_STORAGE_DEBUG_TASKS_DIR)
            : "";
  }

  private boolean checkProperties(Properties properties) {
    String[] propertiesSet = {
      SapsPropertiesConstants.PERMANENT_STORAGE_TASKS_DIR,
      SapsPropertiesConstants.FS_PERMANENT_STORAGE_PATH,
      SapsPropertiesConstants.PERMANENT_STORAGE_BASE_URL
    };

    return SapsPropertiesUtil.checkProperties(properties, propertiesSet);
  }

  private boolean checkPropertiesDebugMode(Properties properties) {
    if (!properties.containsKey(SapsPropertiesConstants.PERMANENT_STORAGE_DEBUG_TASKS_DIR)) {
      LOGGER.error(
          "Required property "
              + SapsPropertiesConstants.PERMANENT_STORAGE_DEBUG_TASKS_DIR
              + " was not set (it's necessary when debug mode)");
      return false;
    }

    LOGGER.debug("All properties for debug mode are set");
    return true;
  }

  @Override
  public boolean archive(SapsImage task) throws IOException {
    String taskId = task.getTaskId();
    LOGGER.info("Archiving task [" + task.getTaskId() + "] to permanent storage.");

    String inputdownloadingLocalDir =
        String.format(
            SAPS_TASK_STAGE_DIR_PATTERN, nfsTempStoragePath, taskId, INPUTDOWNLOADING_DIR);
    String preprocessingLocalDir =
        String.format(SAPS_TASK_STAGE_DIR_PATTERN, nfsTempStoragePath, taskId, PREPROCESSING_DIR);
    String processingLocalDir =
        String.format(SAPS_TASK_STAGE_DIR_PATTERN, nfsTempStoragePath, taskId, PROCESSING_DIR);

    String nfsTaskDir =
        (task.getState() == ImageTaskState.FAILED && this.debugMode)
            ? this.debugTasksDirName
            : this.tasksDirName;
    String nfsTaskDirPath;

    nfsTaskDirPath = createTaskDir(nfsTaskDir, taskId);

    copyDirToDir(inputdownloadingLocalDir, nfsTaskDirPath);
    copyDirToDir(preprocessingLocalDir, nfsTaskDirPath);
    copyDirToDir(processingLocalDir, nfsTaskDirPath);
    return true;
  }

  @Override
  public boolean delete(SapsImage task) throws IOException {
    String nfsTaskDir =
        (task.getState() == ImageTaskState.FAILED && this.debugMode)
            ? this.debugTasksDirName
            : this.tasksDirName;
    String taskDirPath =
        String.format(
            NFS_STORAGE_TASK_DIR_PATTERN, nfsPermanentStoragePath, nfsTaskDir, task.getTaskId());
    File taskDir = new File(taskDirPath);
    if (!taskDir.exists()) {
      throw new FileNotFoundException(
          "The task dir ["
              + taskDirPath
              + "] was not found on nfs storage directory ["
              + nfsPermanentStoragePath
              + "]");
    }
    FileUtils.deleteDirectory(taskDir);
    return true;
  }

  @Override
  public List<AccessLink> generateAccessLinks(SapsImage task) {
    String taskId = task.getTaskId();
    List<AccessLink> taskDataLinks = new LinkedList<>();

    String dirAccessLink = String.format(NFS_STORAGE_TASK_URL_PATTERN, this.baseUrl, taskId);

    // TODO check dirs
    AccessLink inputDownloadingDirAccessLink =
        new AccessLink(INPUTDOWNLOADING_DIR, dirAccessLink + File.separator + INPUTDOWNLOADING_DIR);
    AccessLink preprocessingDirAccessLink =
        new AccessLink(PREPROCESSING_DIR, dirAccessLink + File.separator + PREPROCESSING_DIR);
    AccessLink processingDirAccessLink =
        new AccessLink(PROCESSING_DIR, dirAccessLink + File.separator + PROCESSING_DIR);

    taskDataLinks.add(inputDownloadingDirAccessLink);
    taskDataLinks.add(preprocessingDirAccessLink);
    taskDataLinks.add(processingDirAccessLink);

    return taskDataLinks;
  }

  private void copyDirToDir(String src, String dest) throws IOException {
    File srcDir = new File(src);
    File destDir = new File(dest);
    // The destination directory is created if it does not exist.
    // If the destination directory did exist, then this method merges the source with the
    // destination, with the source taking precedence.
    LOGGER.debug("Copying [" + src + "] into [" + dest + "]");
    FileUtils.copyDirectoryToDirectory(srcDir, destDir);
  }

  private String createTaskDir(String tasksDir, String taskId) throws IOException {
    File storageDir = new File(nfsPermanentStoragePath);
    if (!storageDir.exists()) {
      throw new FileNotFoundException(
          "The nfs storage directory [" + nfsPermanentStoragePath + "] was not found");
    }
    File nfsTaskDir =
        new File(
            String.format(NFS_STORAGE_TASK_DIR_PATTERN, nfsPermanentStoragePath, tasksDir, taskId));
    FileUtils.forceMkdir(nfsTaskDir);
    return nfsTaskDir.getAbsolutePath();
  }
}
