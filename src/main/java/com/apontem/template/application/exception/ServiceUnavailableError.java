package com.apontem.template.application.exception;

public class ServiceUnavailableError extends RuntimeException {
    public ServiceUnavailableError() {
        super("The service is currently unavailable.");
    }
}
