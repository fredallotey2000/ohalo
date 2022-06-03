/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apontem.template.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bsystems
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentSchedule extends LoanModel {

    ArrayList<PaymentScheduleModel> paymentScheduleModel;

    public PaymentSchedule() {
    }

    public PaymentSchedule(LoanModel loanModel) {
           super.setPrincipal(loanModel.getPrincipal());
                   super.setNominalAnnualInterestRate(loanModel.getNominalAnnualInterestRate());
                           super.setPeriodsPerYear(loanModel.getPeriodsPerYear());
                                   super.setNumberOfPayments(loanModel.getNumberOfPayments());
        super.setApprovedBy(loanModel.getApprovedBy());
        super.setApprovedDate(loanModel.getApprovedDate());
        super.setCustomerAccountId(loanModel.getCustomerAccountId());
        super.setLastupdateby(loanModel.getLastupdateby());
        super.setLastupdatedate(loanModel.getLastupdatedate());
        super.setLoanId(loanModel.getLoanId());
        super.setMontlyPayments(loanModel.getMontlyPayments());
        super.setProcessingFee(loanModel.getProcessingFee());
        super.setStartDate(loanModel.getStartDate());
        super.setStatus(loanModel.getStatus());
        super.setLoanType(loanModel.getLoanType());
        super.setLoanId(loanModel.getLoanId());
    }

    public ArrayList<PaymentScheduleModel> getPaymentScheduleModel() {
        return paymentScheduleModel;
    }

    public void setPaymentScheduleModel(ArrayList<PaymentScheduleModel> paymentScheduleModel) {
        this.paymentScheduleModel = paymentScheduleModel;
    }

}
