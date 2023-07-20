package com.perficient.managementservice.ManagementService.exception;

public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException(String message)
    {
        super(message);
    }
}
