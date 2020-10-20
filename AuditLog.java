package com.rumango.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SIASTM_SYSTEM_LOG")
public class AuditLog 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	@Column(name="USER_ID")
	private String userId;
	@Column(name="ACTION")
	private String action;
	@Column(name="SCREEN_NAME")
	private String screenName;
	@Column(name="IP_ADDRESS")
	private String ipAddress;
	@Column(name="MACHINE")
	private String machine;
	@Column(name="START_TIME")
	private Timestamp startTime;
	@Column(name="END_TIME")
	private Timestamp endTime;
	@Column(name="CREATED_BY")
	private String createdBy;
	@Column(name="AUTHORIZE_BY")
	private String authorizeBy;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getMachine() {
		return machine;
	}
	public void setMachine(String machine) {
		this.machine = machine;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getAuthorizeBy() {
		return authorizeBy;
	}
	public void setAuthorizeBy(String authorizeBy) {
		this.authorizeBy = authorizeBy;
	}
	@Override
	public String toString() {
		return "AuditLog [id=" + id + ", userId=" + userId + ", action=" + action + ", screenName=" + screenName
				+ ", ipAddress=" + ipAddress + ", machine=" + machine + ", startTime=" + startTime + ", endTime="
				+ endTime + ", createdBy=" + createdBy + ", authorizeBy=" + authorizeBy + "]";
	}
	

}
