package com.apontem.template.application.exception;

public class UnexpectedError extends RuntimeException {
    public UnexpectedError(Throwable e) {
        super("Unexpected error encountered");
    }
}
