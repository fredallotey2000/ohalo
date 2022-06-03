package com.apontem.template.application.controller;

import com.apontem.template.application.model.LoanModel;
import com.apontem.template.application.model.PaymentSchedule;
import com.apontem.template.application.model.PaymentScheduleModel;
import com.apontem.template.application.service.PaymentScheduleCalculator;
import java.text.SimpleDateFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * A controller class marks the entry point for our endpoint
 */
@Slf4j
@RestController
@RequestMapping("/calculator/payment-schedule")
public class Calculator {

    @RequestMapping(
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity callback_DAT_POST(
            @RequestBody LoanModel loanModel,
            @RequestParam(value = "save", required = false) String save
    ) {

        loanModel.setPeriodsPerYear("12");
        loanModel.setProcessingFee("3");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        formatter.format(date);

        loanModel.setStartDate(formatter.format(date));
        PaymentScheduleCalculator paymentScheduleCalculator = new PaymentScheduleCalculator(loanModel);
        PaymentSchedule paymentSchedule = new PaymentSchedule(loanModel);
        ArrayList<PaymentScheduleModel> paymentSchedule1 = paymentScheduleCalculator.getPaymentSchedule();
        paymentSchedule.setPaymentScheduleModel(paymentScheduleCalculator.getPaymentSchedule());
      //  return Response.ok(paymentSchedule).build();
        
        return ResponseEntity.ok().body(paymentSchedule);
    }
}
