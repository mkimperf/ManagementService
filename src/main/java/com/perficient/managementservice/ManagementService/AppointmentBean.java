package com.perficient.managementservice.ManagementService;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AppointmentBean {
	
	private String apptName;

	private String apptType;
	
	private String description;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	private String metadata;
	
	public AppointmentBean() {
		
	}

	public AppointmentBean(String apptName, String apptType, String description, LocalDateTime startTime,
			LocalDateTime endTime, String metadata) {
		super();
		this.apptName = apptName;
		this.apptType = apptType;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.metadata = metadata;
	}
	
	public String getApptName() {
		return apptName;
	}

	public void setApptName(String apptName) {
		this.apptName = apptName;
	}

	public String getApptType() {
		return apptType;
	}

	public void setApptType(String apptType) {
		this.apptType = apptType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
}
