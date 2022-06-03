package com.apontem.template.application.security.exception;

public class ForbiddenAccess extends Throwable {
    public ForbiddenAccess() {
        super("Access denied");
    }
}
