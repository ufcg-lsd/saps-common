package saps.common.utils;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import saps.common.exceptions.SapsException;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExecutionScriptTagUtil {

	private static final Logger LOGGER = Logger.getLogger(ExecutionScriptTagUtil.class);

	protected static final String ERROR_MSG__TYPE_NOT_FOUND = "Execution Script Tag type not found.";

	public static String INPUT_DOWNLOADER = ExecutionScriptTag.INPUT_DOWNLOADER;
	public static String PROCESSING = ExecutionScriptTag.PROCESSING;
	public static String PRE_PROCESSING = ExecutionScriptTag.PRE_PROCESSING;

	private static final String NAME_KEY_JSON = "name";
	private static final String DOCKER_TAG_KEY_JSON = "docker_tag";
	private static final String DOCKER_REPOSITORY_KEY_JSON = "docker_repository";
	private static final String MEMORY_USAGE_KEY_JSON = "memory_usage";
	private static final String CPU_USAGE_KEY_JSON = "cpu_usage";

	public static ExecutionScriptTag getExecutionScriptTag(String tagsFilePath, String name, String type) throws Exception {
		LOGGER.info("Getting Execution Script Tag [" + tagsFilePath + "] by name [" + name + "] and type [" + type + "]");
		JSONObject jsonScriptTagFile = ExecutionScriptTagUtil.getJsonExecutionScriptTag(tagsFilePath);
		ExecutionScriptTag executionScriptTag = findExecutionScriptTag(name, type, jsonScriptTagFile);
		LOGGER.debug("Execution Script Tag Found: " + executionScriptTag.toString());
		return executionScriptTag;
	}

	protected static ExecutionScriptTag findExecutionScriptTag(String name, String type, JSONObject jsonExecScriptTagFile) throws SapsException {
		try {
			JSONArray jArrayScriptTags = jsonExecScriptTagFile.optJSONArray(type);
			if (jArrayScriptTags == null) {
				throw new Exception(ERROR_MSG__TYPE_NOT_FOUND);
			}

			for (int i = 0; i < jArrayScriptTags.length(); i++) {
				JSONObject jsonScriptTag = jArrayScriptTags.optJSONObject(i);
				String scriptTagName = jsonScriptTag.optString(NAME_KEY_JSON);
				if (scriptTagName != null && scriptTagName.equals(name)) {
					String dockerTag = jsonScriptTag.optString(DOCKER_TAG_KEY_JSON);
					String dockerRepository = jsonScriptTag.optString(DOCKER_REPOSITORY_KEY_JSON);
					String memoryUsage = jsonScriptTag.optString(MEMORY_USAGE_KEY_JSON);
					String cpuUsage = jsonScriptTag.optString(CPU_USAGE_KEY_JSON);

					return new ExecutionScriptTag(name, dockerRepository, dockerTag, memoryUsage, cpuUsage, type);
				}
			}
			throw new Exception("Execution Script Tag by name (" + name + ") not found.");
		} catch (Exception e) {
			throw new SapsException(e.getMessage(), e);
		}
	}

	protected static JSONObject getJsonExecutionScriptTag(String scriptTagPath) throws Exception {
		try {
			String scriptTagJsonPath = scriptTagPath;
			InputStream is = new FileInputStream(scriptTagJsonPath);
			String jsonTxt = IOUtils.toString(is, "UTF-8");
			return new JSONObject(jsonTxt);
		} catch (Exception e) {
			String errorMsg = "Error while getting Execution Script Tag file.";
			LOGGER.error(errorMsg, e);
			throw new Exception(errorMsg);
		}
	}

}