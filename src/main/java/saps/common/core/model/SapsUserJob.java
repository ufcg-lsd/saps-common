package saps.common.core.model;

import java.io.Serializable;
import java.sql.Date;

import antlr.collections.List;

public class SapsUserJob implements Serializable {

	private List<String> tasksIds;
	private String jobId;
	private String jobLabel;
	private String lowerLeftLatitude;
	private String lowerLeftLongitude;
	private String upperRightLatitude;
	private String upperRightLongitude;
	private JobState state;
	private String userEmail;
	private String jobLabel;
	private Date startDate;
	private Date endDate;
	private int priorty;
	private List<String> tasksIds;
	private Date updatedTime;
	private Date creationTime;


	public SapsUserJob(String jobId, 
			String lowerLeftLatitude, String lowerLeftLongitude,
			String upperRightLatitude, String upperRightLongitude,
			String state, String userEmail, String jobLabel,
			Date startDate, Date endDate, int priority, List<String> taskIds,
			Date updatedTime, Date creationTime) {
            
			this.jobId = jobId;
			this.lowerLeftLatitude = lowerLeftLatitude;
			this.lowerLeftLongitude = lowerLeftLongitude;
			this.upperRightLatitude = upperRightLatitude;
			this.upperRightLongitude = upperRightLongitude;
			this.state = state;
			this.userEmail = userEmail;
			this.jobLabel = jobLabel;					
			this.startDate = startDate;
			this.endDate = endDate;
			this.priorty = priority;
			this.tasksIds = tasksIds;
			this.updatedTime = updatedTime;
			this.creationTime = creationTime;
	}


	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getLowerLeftLatitude() {
		return this.lowerLeftLatitude;
	}

	public void setLowerLeftLatitude(String lowerLeftLatitude) {
		this.lowerLeftLatitude = lowerLeftLatitude;
	}

	public String getLowerLeftLongitude() {
		return this.lowerLeftLongitude;
	}

	public void setLowerLeftLongitude(String lowerLeftLongitude) {
		this.lowerLeftLongitude = lowerLeftLongitude;
	}

	public String getUpperRightLatitude() {
		return this.upperRightLatitude;
	}

	public void setUpperRightLatitude(String upperRightLatitude) {
		this.upperRightLatitude = upperRightLatitude;
	}

	public String getUpperRightLongitude() {
		return this.upperRightLongitude;
	}

	public void setUpperRightLongitude(String upperRightLongitude) {
		this.upperRightLongitude = upperRightLongitude;
	}

	public JobState getState() {
		return this.state;
	}

	public void setState(JobState state) {
		this.state = state;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getJobLabel() {
		return this.jobLabel;
	}

	public void setJobLabel(String jobLabel) {
		this.jobLabel = jobLabel;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public List<String> getTaskIds() {
		return this.tasksIds;
	}

	public void setTasksIds(List<String> tasksIds) {
		this.tasksIds = tasksIds;
	}

	public Date getUpdatedTime() {
		return this.updatedTime;
	}

	public void setUpdatedTIme(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Date getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
								   
}
							