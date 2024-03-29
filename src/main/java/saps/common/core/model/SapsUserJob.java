package saps.common.core.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import saps.common.core.model.enums.JobState;

public class SapsUserJob implements Serializable {

  private String jobId;
  private String lowerLeftLatitude;
  private String lowerLeftLongitude;
  private String upperRightLatitude;
  private String upperRightLongitude;
  private JobState state;
  private String userEmail;
  private String jobLabel;
  private Date startDate;
  private Date endDate;
  private int priority;
  private List<String> tasksIds;
  private Timestamp creationTime;

  public SapsUserJob(
      String jobId,
      String lowerLeftLatitude,
      String lowerLeftLongitude,
      String upperRightLatitude,
      String upperRightLongitude,
      JobState state,
      String userEmail,
      String jobLabel,
      Date startDate,
      Date endDate,
      int priority,
      List<String> taskIds,
      Timestamp creationTime) {

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
    this.priority = priority;
    this.tasksIds = taskIds;
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

  public Timestamp getCreationTime() {
    return this.creationTime;
  }

  public void setCreationTime(Timestamp creationTime) {
    this.creationTime = creationTime;
  }

  public JSONObject toJSON() throws JSONException {
    JSONObject json = new JSONObject();

    json.put("jobId", jobId);
    json.put("lowerLeftLatitude", lowerLeftLatitude);
    json.put("lowerLeftLongitude", lowerLeftLongitude);
    json.put("upperRightLatitude", upperRightLatitude);
    json.put("upperRightLongitude", upperRightLongitude);
    json.put("state", state);
    json.put("userEmail", userEmail);
    json.put("jobLabel", jobLabel);
    json.put("startDate", startDate);
    json.put("endDate", endDate);
    json.put("priority", priority);
    json.put("tasksIds", tasksIds);
    json.put("creationTime", creationTime);
    
    return json;
  }


}
