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
}
