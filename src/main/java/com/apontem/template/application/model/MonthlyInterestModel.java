/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apontem.template.application.model;

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
public class MonthlyInterestModel extends InterestModel implements EntityModel {

    private String monthlyInterest;

    ArrayList list = null;

    public MonthlyInterestModel() {
    }

    public MonthlyInterestModel(Object[] monthlyInterest) {
            
    }

    public String getMonthlyInterest() {
        return monthlyInterest;
    }

    public void setMonthlyInterest(String monthlyInterest) {
        this.monthlyInterest = monthlyInterest;
    }

    @Override
    @XmlTransient
    public String[] toArray() {
        String[] accInfo = new String[8];
//        accInfo[0] = processingFee;
//        accInfo[1] = nominalAnnualInterestRate;
//        accInfo[2] = periodsPerYear;
//        accInfo[3] = startDate;
//        accInfo[4] = principal;
//        accInfo[5] = montlyPayments;
//        accInfo[6] = numberOfPayments;
//        accInfo[7] = loanId;

        return accInfo;
    }

    @Override
    @XmlTransient
    public String getPrimaryKey() {
        return "";
//        return loanId;
    }

    @Override
    @XmlTransient
    public EntityModel toXMLElement(Object[] recordData) {

//        this.processingFee = recordData[0].toString();
//        this.nominalAnnualInterestRate = recordData[1].toString();
//        this.periodsPerYear = recordData[2].toString();
//        this.startDate = recordData[3].toString();
//        this.principal = recordData[4].toString();
//        this.montlyPayments = recordData[5].toString();
//        this.numberOfPayments = recordData[6].toString();
//        this.loanId = recordData[7].toString();
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
