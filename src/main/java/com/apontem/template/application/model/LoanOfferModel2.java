/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apontem.template.application.model;

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
public class LoanOfferModel2 implements EntityModel{

    String loanNumber;
    String principal;
    String rate;
    String penalRate;
    String term;
    Lender lender;
    Borrower borrower;
    String offeredAt;

    public String getLoanNumber() {
        return loanNumber;
    }

    public LoanOfferModel2(String loanNumber, String principal, String rate, String penalRate, String term, Lender lender, Borrower borrower, String offeredAt) {
        this.loanNumber = loanNumber;
        this.principal = principal;
        this.rate = rate;
        this.penalRate = penalRate;
        this.term = term;
        this.lender = lender;
        this.borrower = borrower;
        this.offeredAt = offeredAt;
    }
    
    

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPenalRate() {
        return penalRate;
    }

    public void setPenalRate(String penalRate) {
        this.penalRate = penalRate;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Lender getLender() {
        return lender;
    }

    public void setLender(Lender lender) {
        this.lender = lender;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public String getOfferedAt() {
        return offeredAt;
    }

    public void setOfferedAt(String offeredAt) {
        this.offeredAt = offeredAt;
    }

    @Override
    public String[] toArray() {
        return null;
    }

    @Override
    public String getPrimaryKey() {
        return null;
    }

    @Override
    public EntityModel toXMLElement(Object[] recordData) {
        return null;
    }

    @Override
    public void setList(ArrayList<Object[]> records) {
        
    }

    @Override
    public ArrayList<Object[]> getList() {
        return null;
    }
    
    

}
