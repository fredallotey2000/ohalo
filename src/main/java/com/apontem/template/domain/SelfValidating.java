package com.apontem.template.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Set;

public interface SelfValidating<T> {
    @JsonIgnore
    default Set<ConstraintViolation<Object>> getViolations() {
        var validator = Validation.buildDefaultValidatorFactory().getValidator();
        return validator.validate((T)this);
    }
}
