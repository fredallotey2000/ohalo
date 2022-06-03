/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apontem.template.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bsystems
 */
@XmlRootElement
public class PaymentScheduleModel implements EntityModel {

    private String paymentScheduleId;
    private String paymentDate;
    private String beginningBalance;
    private String interest;
    private String principal;
    private String endingBalance;
    private String monthlyPayment;
    private String totalPayment;
    private String paymentCharges = "2.5";
    private String loanId;
    private String ststus;
    private String borrowerNotified;
    private String lenderNotified;
    private String amountPaid;
    private String amountLeft;

    @JsonIgnore
    ArrayList list = null;

    public PaymentScheduleModel(String paymentScheduleId,
            String paymentDate,
            String beginningBalance,
            String interest,
            String principal,
            String endingBalance,
            String monthlyPayment,
            String paymentCharges,
            String totalPayment,
            String loanId,
            String amountPaid,
            String amountLeft,
            String ststus) {

        this.paymentScheduleId = paymentScheduleId;
        this.paymentDate = paymentDate;
        this.beginningBalance = beginningBalance;
        this.interest = interest;
        this.principal = principal;
        this.endingBalance = endingBalance;
        this.monthlyPayment = monthlyPayment;
        this.paymentCharges = paymentCharges;
        this.totalPayment = totalPayment;
        this.loanId = loanId;
        this.amountPaid = amountPaid;
        this.amountLeft = amountLeft;
        this.ststus = ststus;

    }

    public String getStstus() {
        return ststus;
    }

    public String getBorrowerNotified() {
        return borrowerNotified;
    }

    public void setBorrowerNotified(String borrowerNotified) {
        this.borrowerNotified = borrowerNotified;
    }

    public String getLenderNotified() {
        return lenderNotified;
    }

    public String getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(String amountLeft) {
        this.amountLeft = amountLeft;
    }

    public void setLenderNotified(String lenderNotified) {
        this.lenderNotified = lenderNotified;
    }

    public void setStstus(String ststus) {
        this.ststus = ststus;
    }

    public PaymentScheduleModel() {
    }

    public String getPaymentScheduleId() {
        return paymentScheduleId;
    }

    public void setPaymentScheduleId(String paymentScheduleId) {
        this.paymentScheduleId = paymentScheduleId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getBeginningBalance() {
        return beginningBalance;
    }

    public void setBeginningBalance(String beginningBalance) {
        this.beginningBalance = beginningBalance;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getEndingBalance() {
        return endingBalance;
    }

    public void setEndingBalance(String endingBalance) {
        this.endingBalance = endingBalance;
    }

    public String getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(String monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(String totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getPaymentCharges() {
        return paymentCharges;
    }

    public void setPaymentCharges(String paymentCharges) {
        this.paymentCharges = paymentCharges;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Override
    @XmlTransient
    public String[] toArray() {
        String[] accInfo = new String[13];
        accInfo[0] = paymentScheduleId;
        accInfo[1] = paymentDate;
        accInfo[2] = beginningBalance;
        accInfo[3] = interest;
        accInfo[4] = principal;
        accInfo[5] = endingBalance;
        accInfo[6] = monthlyPayment;
        accInfo[7] = paymentCharges;
        accInfo[8] = totalPayment;
        accInfo[9] = loanId;
        accInfo[10] = amountPaid;
        accInfo[11] = amountLeft;
        accInfo[12] = ststus;
        return accInfo;
    }

    @Override
    @XmlTransient
    public String getPrimaryKey() {
        return paymentScheduleId;
    }

    @Override
    @XmlTransient
    public EntityModel toXMLElement(Object[] recordData) {

        this.paymentScheduleId = recordData[0].toString();
        this.paymentDate = recordData[1].toString();
        this.beginningBalance = recordData[2].toString();
        this.interest = recordData[3].toString();
        this.principal = recordData[4].toString();
        this.endingBalance = recordData[5].toString();
        this.monthlyPayment = recordData[6].toString();
        this.paymentCharges = recordData[7].toString();
        this.totalPayment = recordData[8].toString();
        this.loanId = recordData[9].toString();
        this.amountPaid = recordData[10].toString();
        this.amountLeft = recordData[11].toString();
        this.ststus = recordData[12].toString();
        return this;
    }

    @Override
    public void setList(ArrayList<Object[]> records) {
        list = records;
    }

    @Override
    public ArrayList<Object[]> getList() {
        return list;
    }

}
