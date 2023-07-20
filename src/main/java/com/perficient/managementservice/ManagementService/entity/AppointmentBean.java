package com.perficient.managementservice.ManagementService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentBean {


	private Integer aptId;
	private Integer userId;
	private String aptType;
	private String aptName;
	private String description;
	private String startTime;
	private String endTime;
	private String metaData;
	

		
}
