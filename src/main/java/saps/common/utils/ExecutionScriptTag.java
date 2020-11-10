package saps.common.utils;

import java.util.HashMap;
import java.util.Map;

import saps.common.exceptions.SapsException;

public class ExecutionScriptTag {

	public static String INPUT_DOWNLOADER = "inputdownloading";
	public static String PROCESSING = "processing";
	public static String PRE_PROCESSING = "preprocessing";

	public static String MEMORY_REQUIREMENT = "memory";
	public static String REGEXP_MEMORY_REQUIREMENT = "^[0-9]+[EPTGMK]$";

	public static String CPU_REQUIREMENT = "cpu";
	public static String REGEXP_CPU_REQUIREMENT = "^[0-9]+m$";

	private String type;
	private String name;
	private String dockerRepository;
	private String dockerTag;
	private Map<String, String> requirements;

	public ExecutionScriptTag(String name, String dockerRepository, String dockerTag, String memoryUsage,
			String cpuUsage, String type) throws SapsException {
		this.name = name;
		this.dockerRepository = dockerRepository;
		this.dockerTag = dockerTag;
		this.type = type;
		this.requirements = new HashMap<String, String>();
		this.requirements.put(MEMORY_REQUIREMENT, memoryUsage);
		this.requirements.put(CPU_REQUIREMENT, cpuUsage);
		ExecutionScriptTagUtil.checkRequirement(memoryUsage, REGEXP_MEMORY_REQUIREMENT);
		ExecutionScriptTagUtil.checkRequirement(cpuUsage, REGEXP_CPU_REQUIREMENT);
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getDockerRepository() {
		return dockerRepository;
	}

	public String getDockerTag() {
		return dockerTag;
	}

	public String getMemoryUsage() {
		return requirements.get(MEMORY_REQUIREMENT);
	}

	public String getCpuUsage() {
		return requirements.get(CPU_REQUIREMENT);
	}

	public String formatImageDocker() {
		return dockerRepository + ":" + dockerTag;
	}

	@Override
	public String toString() {
		return "ScriptTag [type=" + type + ", name=" + name + ", dockerRepository=" + dockerRepository + ", dockerTag="
				+ dockerTag + ", memoryUsage=" + getMemoryUsage() + ", cpuUsage=" + getCpuUsage() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dockerRepository == null) ? 0 : dockerRepository.hashCode());
		result = prime * result + ((dockerTag == null) ? 0 : dockerTag.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((getMemoryUsage() == null) ? 0 : getMemoryUsage().hashCode());
		result = prime * result + ((getCpuUsage() == null) ? 0 : getCpuUsage().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExecutionScriptTag other = (ExecutionScriptTag) obj;
		if (dockerRepository == null) {
			if (other.dockerRepository != null)
				return false;
		} else if (!dockerRepository.equals(other.dockerRepository))
			return false;
		if (dockerTag == null) {
			if (other.dockerTag != null)
				return false;
		} else if (!dockerTag.equals(other.dockerTag))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (getMemoryUsage() == null) {
			if (other.getMemoryUsage() != null)
				return false;
		} else if (!getMemoryUsage().equals(other.getMemoryUsage()))
			return false;
		if (getCpuUsage() == null) {
			if (other.getCpuUsage() != null)
				return false;
		} else if (!getCpuUsage().equals(other.getCpuUsage()))
			return false;
		return true;
	}

}