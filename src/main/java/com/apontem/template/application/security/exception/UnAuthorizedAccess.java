package com.apontem.template.application.security.exception;

public class UnAuthorizedAccess extends Throwable {
    public UnAuthorizedAccess() {
        super("Not authenticated. Please authenticate to continue");
    }
}
