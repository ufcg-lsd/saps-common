package saps.common.utils;

public class ExecutionScriptTag {

	public static String INPUT_DOWNLOADER = "inputdownloading";
	public static String PROCESSING = "processing";
	public static String PRE_PROCESSING = "preprocessing";

	private String type;
	private String name;
	private String dockerRepository;
	private String dockerTag;
	private String memoryUsage;
	private String cpuUsage;

	public ExecutionScriptTag(String name, String dockerRepository, String dockerTag, String memoryUsage,
			String cpuUsage, String type) {
		this.name = name;
		this.dockerRepository = dockerRepository;
		this.dockerTag = dockerTag;
		this.type = type;
		this.memoryUsage = memoryUsage;
		this.cpuUsage = cpuUsage;
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
		return memoryUsage;
	}

	public String getCpuUsage() {
		return cpuUsage;
	}

	public String formatImageDocker() {
		return dockerRepository + ":" + dockerTag;
	}

	@Override
	public String toString() {
		return "ScriptTag [type=" + type + ", name=" + name + ", dockerRepository=" + dockerRepository + ", dockerTag="
				+ dockerTag + ", memoryUsage=" + memoryUsage + ", cpuUsage=" + cpuUsage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dockerRepository == null) ? 0 : dockerRepository.hashCode());
		result = prime * result + ((dockerTag == null) ? 0 : dockerTag.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((memoryUsage == null) ? 0 : memoryUsage.hashCode());
		result = prime * result + ((cpuUsage == null) ? 0 : cpuUsage.hashCode());
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
		if (memoryUsage == null) {
			if (other.memoryUsage != null)
				return false;
		} else if (!memoryUsage.equals(other.memoryUsage))
			return false;
		if (cpuUsage == null) {
			if (other.cpuUsage != null)
				return false;
		} else if (!cpuUsage.equals(other.cpuUsage))
			return false;
		return true;
	}

}