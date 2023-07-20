package com.perficient.managementservice.ManagementService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("management-service")
public class Configuration {
	
	@Value("${user_service}")
	private String user_service;
	@Value("${appointment_service}")
	private String appointment_service;
	
	public Configuration() {

	}
	
	public String getUserservice() {
		return user_service;
	}

	public void setUserservice(String userservice) {
		this.user_service = userservice;
	}

	public String getAppointmentservice() {
		return appointment_service;
	}

	public void setAppointmentservice(String appointmentservice) {
		this.appointment_service = appointmentservice;
	}

}
