package com.apontem.template.application.exception;

import lombok.Getter;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Getter
public class InputViolations extends RuntimeException {
    private final Set<ConstraintViolation<Object>> violations;

    public InputViolations(Set<ConstraintViolation<Object>> violations) {
        this.violations = violations;
    }

}
