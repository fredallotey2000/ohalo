/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvirtual.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bsystems
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class InterestModel {

    private String nominalAnnualInterestRate;
    private String periodsPerYear;
    private String outstandingPrincipal;
    private String interestDate;
    private String loanId;

    ArrayList list = null;

    public InterestModel() {

    }

    public InterestModel(Object[] monthlyInterest) {
        this.nominalAnnualInterestRate = monthlyInterest[0].toString();
        this.periodsPerYear = monthlyInterest[0].toString();
        this.outstandingPrincipal = monthlyInterest[0].toString();
        this.interestDate = monthlyInterest[0].toString();
        this.loanId = monthlyInterest[0].toString();
    }

    public String getNominalAnnualInterestRate() {
        return nominalAnnualInterestRate;
    }

    public void setNominalAnnualInterestRate(String nominalAnnualInterestRate) {
        this.nominalAnnualInterestRate = nominalAnnualInterestRate;
    }

    public String getPeriodsPerYear() {
        return periodsPerYear;
    }

    public void setPeriodsPerYear(String periodsPerYear) {
        this.periodsPerYear = periodsPerYear;
    }

    public String getOutstandingPrincipal() {
        return outstandingPrincipal;
    }

    public void setOutstandingPrincipal(String outstandingPrincipal) {
        this.outstandingPrincipal = outstandingPrincipal;
    }

    public String getInterestDate() {
        return interestDate;
    }

    public void setInterestDate(String interestDate) {
        this.interestDate = interestDate;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

}
