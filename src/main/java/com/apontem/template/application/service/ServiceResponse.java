package com.apontem.template.application.service;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ServiceResponse<T> {
    public Status status;
    public String message;
    public T payload;

    public enum Status {
        OK, BAD_REQUEST, SERVICE_UNAVAILABLE;

        public static Status from (HttpStatus httpStatus) {
            if (httpStatus.is4xxClientError()) return BAD_REQUEST;
            if (httpStatus.is5xxServerError()) return SERVICE_UNAVAILABLE;
            return OK;
        }

        public boolean isSuccessful() {
            return OK.equals(this);
        }

        public boolean isBadRequest() {
            return BAD_REQUEST.equals(this);
        }

        public boolean isServiceUnavailable() {
            return SERVICE_UNAVAILABLE.equals(this);
        }
    }
}
