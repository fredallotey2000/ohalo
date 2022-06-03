package com.apontem.template.application.controller.helper;

import com.apontem.template.application.exception.BadRequest;
import com.apontem.template.application.exception.ServiceUnavailableError;
import com.apontem.template.application.exception.UnexpectedError;
import lombok.Getter;
import org.springframework.cloud.sleuth.TraceContext;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.Optional;

/**
 * This class allows us to setup a common responses to exceptions
 * thrown from our controller methods.
 * We can handle our own defined exceptions or exceptions built into whatever libraries
 * we are using
 */
@ControllerAdvice
public class ControllerAdvisor {
    private final Tracer tracer;

    public ControllerAdvisor(Tracer tracer) {
        this.tracer = tracer;
    }

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<?> handleBadRequest(Exception e) {
        return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
    }

    @ExceptionHandler(value = {UnexpectedError.class, ServiceUnavailableError.class})
    public ResponseEntity<?> handleUnexpectedError(Exception e) {
        Error error = new Error();
        error.message = e.getMessage();

        Optional.ofNullable(tracer.currentSpan())
                .ifPresent(t -> {
                    TraceContext traceContext = t.context();
                    error.traceId = String.format(
                            "%s.%s",
                            traceContext.traceId(),
                            traceContext.spanId());
                });
        return ResponseEntity.internalServerError().body(error);
    }

    @Getter
    private static class Error {
        private String traceId;
        private String message;
    }
}
