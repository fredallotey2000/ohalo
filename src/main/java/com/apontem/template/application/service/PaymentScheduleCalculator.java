/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apontem.template.application.service;


import com.apontem.template.application.model.LoanModel;
import com.apontem.template.application.model.PaymentScheduleModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bsystems
 */
public final class PaymentScheduleCalculator {

    ArrayList<PaymentScheduleModel> paymentSchedule;
    LoanModel loanModel;
    String paymentDate;
    PaymentScheduleModel previousPaymentScheduleModel;
    private double interest;
    private double principal;
    String monthlyPayments;

    public PaymentScheduleCalculator(LoanModel loanModel) {
        this.loanModel = loanModel;
        paymentSchedule = new ArrayList<PaymentScheduleModel>();
        calculateMonthlyPayment();
        preparePaymentSchedule();
    }

    public void calculateMonthlyPayment() {

        double principal = Double.parseDouble(loanModel.getPrincipal());
        double rate = ((Double.parseDouble(loanModel.getNominalAnnualInterestRate()) / 100)
                / Double.parseDouble(loanModel.getPeriodsPerYear()));
        int time = Integer.parseInt(loanModel.getNumberOfPayments());
        double p = (principal * rate) / (1 - Math.pow(1 + rate, -time));
        monthlyPayments = Double.toString(p);

    }

    public ArrayList<PaymentScheduleModel> getPaymentSchedule() {
        return paymentSchedule;
    }

    public void setPaymentSchedule(ArrayList<PaymentScheduleModel> paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public void preparePaymentSchedule() {
        for (int i = 0; i < Integer.parseInt(loanModel.getNumberOfPayments()); i++) {
            PaymentScheduleModel paymentScheduleModel = new PaymentScheduleModel();
            paymentScheduleModel.setInterest(calculateInterest());
            paymentScheduleModel.setBeginningBalance(calculateBeginningBalance());
            paymentScheduleModel.setPaymentDate(calculatePaymentDate());
            paymentScheduleModel.setPrincipal(calculatePrincipal());
            paymentScheduleModel.setTotalPayment(
                    Double.toString(Double.parseDouble(paymentScheduleModel.getPaymentCharges()) + Double.parseDouble(calculateTotalpayment())));
            paymentScheduleModel.setMonthlyPayment(calculateTotalpayment());
            paymentScheduleModel.setEndingBalance(calculateEndingBalance());
            paymentScheduleModel.setLoanId(loanModel.getLoanId());
            paymentScheduleModel.setStstus("YET TO");
            paymentScheduleModel.setAmountPaid("0");
            paymentScheduleModel.setAmountLeft(
                    Double.toString(Double.parseDouble(paymentScheduleModel.getPaymentCharges()) + Double.parseDouble(calculateTotalpayment())));
            paymentSchedule.add(paymentScheduleModel);
            // previousPaymentScheduleModel = new PaymentScheduleModel();
            previousPaymentScheduleModel = paymentScheduleModel;
        }
    }

    private String calculatePaymentDate() {
        String startDate = "";
        if (previousPaymentScheduleModel == null) {
            startDate = loanModel.getStartDate();
        } else {
            startDate = previousPaymentScheduleModel.getPaymentDate();
        }
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(startDate);
        } catch (ParseException ex) {
            Logger.getLogger(PaymentScheduleCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        instance.setTime(parse);
        instance.add(Calendar.MONTH, 1);
        return simpleDateFormat.format(instance.getTime());
    }

    private String calculateBeginningBalance() {
        if (previousPaymentScheduleModel == null) {
            return loanModel.getPrincipal();
        } else {
            return previousPaymentScheduleModel.getEndingBalance();
        }
    }

    private String calculateInterest() {
        if (previousPaymentScheduleModel == null) {
            interest = ((Double.parseDouble(loanModel.getNominalAnnualInterestRate()) / 100)
                    / Double.parseDouble(loanModel.getPeriodsPerYear()))
                    * Double.parseDouble(loanModel.getPrincipal());
            return Double.toString(interest);
        } else {
            interest = ((Double.parseDouble(loanModel.getNominalAnnualInterestRate()) / 100)
                    / Double.parseDouble(loanModel.getPeriodsPerYear()))
                    * Double.parseDouble(previousPaymentScheduleModel.getEndingBalance());
            return Double.toString(interest);
        }
    }

    private String calculatePrincipal() {
        if (previousPaymentScheduleModel == null) {
            principal = Double.parseDouble(monthlyPayments) - interest;
            return Double.toString(principal);
        } else {
            principal = Double.parseDouble(monthlyPayments) - interest;
            return Double.toString(principal);
        }
    }

    private String calculateEndingBalance() {
        if (previousPaymentScheduleModel == null) {
            return Double.toString(Double.parseDouble(loanModel.getPrincipal()) - principal);
        } else {
            return Double.toString(Double.parseDouble(previousPaymentScheduleModel.getEndingBalance()) - principal);
        }
    }

    private String calculateTotalpayment() {
        return monthlyPayments;
    }

}
