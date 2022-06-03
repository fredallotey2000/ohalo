package com.apontem.template.application.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

/**
 * A controller class marks the entry point for our endpoint
 */
@Slf4j
@RestController
@RequestMapping("/controller")
public class LoanRequest {


    @GetMapping("/get-time")
    public ResponseEntity<?> getTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        return ResponseEntity.ok(zonedDateTime);
    }

    @GetMapping("/get-time-secured")
    public ResponseEntity<?> getSecuredTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        return ResponseEntity.ok(zonedDateTime);
    }
}
