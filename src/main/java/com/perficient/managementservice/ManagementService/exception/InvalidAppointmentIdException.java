package com.perficient.managementservice.ManagementService.exception;

public class InvalidAppointmentIdException extends RuntimeException{
    public InvalidAppointmentIdException(String message)
    {
        super(message);
    }
}
