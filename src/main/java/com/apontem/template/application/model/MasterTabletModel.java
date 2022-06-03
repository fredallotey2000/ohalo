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
public class MasterTabletModel implements EntityModel {

    private String periodsPerYear;
    private String loanDisbursedMsgLenderSMS;
    private String loanDisbursedMsgLenderEmail;
    private String loanDisbursedMsgBorrowerSMS;
    private String loanDisbursedMsgBorrowerEmail;

    private String loanRepaymentMsgLenderSMS;
    private String loanRepaymentMsgBorrowerSMS;
    private String loanRepaymentMsgLenderEmail;
    private String loanRepaymentMsgBorrowerEmail;

    public MasterTabletModel() {

    }

    public String getPeriodsPerYear() {
        return periodsPerYear;
    }

    public void setPeriodsPerYear(String periodsPerYear) {
        this.periodsPerYear = periodsPerYear;
    }

    public String getLoanDisbursedMsgLenderSMS() {
        return loanDisbursedMsgLenderSMS;
    }

    public void setLoanDisbursedMsgLenderSMS(String loanDisbursedMsgLenderSMS) {
        this.loanDisbursedMsgLenderSMS = loanDisbursedMsgLenderSMS;
    }

    public String getLoanDisbursedMsgLenderEmail() {
        return loanDisbursedMsgLenderEmail;
    }

    public void setLoanDisbursedMsgLenderEmail(String loanDisbursedMsgLenderEmail) {
        this.loanDisbursedMsgLenderEmail = loanDisbursedMsgLenderEmail;
    }

    public String getLoanDisbursedMsgBorrowerSMS() {
        return loanDisbursedMsgBorrowerSMS;
    }

    public void setLoanDisbursedMsgBorrowerSMS(String loanDisbursedMsgBorrowerSMS) {
        this.loanDisbursedMsgBorrowerSMS = loanDisbursedMsgBorrowerSMS;
    }

    public String getLoanDisbursedMsgBorrowerEmail() {
        return loanDisbursedMsgBorrowerEmail;
    }

    public void setLoanDisbursedMsgBorrowerEmail(String loanDisbursedMsgBorrowerEmail) {
        this.loanDisbursedMsgBorrowerEmail = loanDisbursedMsgBorrowerEmail;
    }

    public String getLoanRepaymentMsgLenderSMS() {
        return loanRepaymentMsgLenderSMS;
    }

    public void setLoanRepaymentMsgLenderSMS(String loanRepaymentMsgLenderSMS) {
        this.loanRepaymentMsgLenderSMS = loanRepaymentMsgLenderSMS;
    }

    public String getLoanRepaymentMsgBorrowerSMS() {
        return loanRepaymentMsgBorrowerSMS;
    }

    public void setLoanRepaymentMsgBorrowerSMS(String loanRepaymentMsgBorrowerSMS) {
        this.loanRepaymentMsgBorrowerSMS = loanRepaymentMsgBorrowerSMS;
    }

    public String getLoanRepaymentMsgLenderEmail() {
        return loanRepaymentMsgLenderEmail;
    }

    public void setLoanRepaymentMsgLenderEmail(String loanRepaymentMsgLenderEmail) {
        this.loanRepaymentMsgLenderEmail = loanRepaymentMsgLenderEmail;
    }

    public String getLoanRepaymentMsgBorrowerEmail() {
        return loanRepaymentMsgBorrowerEmail;
    }

    public void setLoanRepaymentMsgBorrowerEmail(String loanRepaymentMsgBorrowerEmail) {
        this.loanRepaymentMsgBorrowerEmail = loanRepaymentMsgBorrowerEmail;
    }

    @Override
    public String[] toArray() {

        String[] accInfo = new String[15];
        accInfo[0] = periodsPerYear;
        accInfo[1] = loanDisbursedMsgLenderSMS;
        accInfo[2] = loanDisbursedMsgLenderEmail;
        accInfo[3] = loanDisbursedMsgBorrowerSMS;
        accInfo[4] = loanDisbursedMsgBorrowerEmail;
        accInfo[6] = loanRepaymentMsgLenderSMS;
        accInfo[7] = loanRepaymentMsgBorrowerSMS;
        accInfo[8] = loanRepaymentMsgLenderEmail;
        accInfo[9] = loanRepaymentMsgBorrowerEmail;

        return accInfo;
    }

    @Override
    public String getPrimaryKey() {
        return null;
    }

    @Override
    public EntityModel toXMLElement(Object[] recordData) {

        this.periodsPerYear = recordData[0].toString();
        this.loanDisbursedMsgLenderSMS = recordData[1].toString();
        this.loanDisbursedMsgLenderEmail = recordData[2].toString();
        this.loanDisbursedMsgBorrowerSMS = recordData[3].toString();
        this.loanDisbursedMsgBorrowerEmail = recordData[4].toString();
        this.loanRepaymentMsgLenderSMS = recordData[5].toString();
        this.loanRepaymentMsgBorrowerSMS = recordData[6].toString();
        this.loanRepaymentMsgLenderEmail = recordData[7].toString();
        this.loanRepaymentMsgBorrowerEmail = recordData[8].toString();

        return this;
    }

    @Override
    public void setList(ArrayList<Object[]> records) {

    }

    @Override
    public ArrayList<Object[]> getList() {
        return null;
    }

}
