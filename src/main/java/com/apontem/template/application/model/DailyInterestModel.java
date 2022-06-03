/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apontem.template.application.model;

import apps.mobile.engine.Journal;
import com.bvirtual.api.service.InterestCalculator;
import com.bvirtual.engine.Main;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bsystems
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyInterestModel implements EntityModel, JournalModel {

    private String interestId;
    private String nominalAnnualInterestRate;
    private String periodsPerYear;
    private String outstandingPrincipal;
    private String interestDate;
    private String loanId;
    private String dailyInterest;
    private String daysInYear;
    @JsonIgnore
    private Object[] journalInfo = null;

    ArrayList list = null;

    public String getNominalAnnualInterestRate() {
        return nominalAnnualInterestRate;
    }

    public void setNominalAnnualInterestRate(String nominalAnnualInterestRate) {
        this.nominalAnnualInterestRate = nominalAnnualInterestRate;
    }

    public String getInterestId() {
        return interestId;
    }

    public void setInterestId(String interestId) {
        this.interestId = interestId;
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

    public DailyInterestModel() {
    }

    public DailyInterestModel(LoanModel loanModel) {

    }

    public String getDaysInYear() {
        return daysInYear;
    }

    public void setDaysInYear(String daysInYear) {
        this.daysInYear = daysInYear;
    }

    public String getDailyInterest() {
        return InterestCalculator.calculateInterest(
                nominalAnnualInterestRate,
                periodsPerYear,
                outstandingPrincipal,
                daysInYear
        );
    }

    public void setDailyInterest(String dailyInterest) {
        this.dailyInterest = dailyInterest;
    }

    @Override
    @XmlTransient
    public String[] toArray() {
        String[] accInfo = new String[8];
        accInfo[0] = interestId;
        accInfo[1] = nominalAnnualInterestRate;
        accInfo[2] = periodsPerYear;
        accInfo[3] = outstandingPrincipal;
        accInfo[4] = interestDate;
        accInfo[5] = loanId;
        accInfo[6] = getDailyInterest();
        accInfo[7] = daysInYear;
        return accInfo;
    }

    @Override
    @XmlTransient
    public ArrayList<String> toArrayList() {
        ArrayList<String> accInfo = new ArrayList<String>();
        accInfo.add(interestId);
        accInfo.add(nominalAnnualInterestRate);
        accInfo.add(periodsPerYear);
//        accInfo.add("INT: ON " + outstandingPrincipal + " ON " + interestDate.replaceAll("/", dailyInterest));
        accInfo.add(outstandingPrincipal);
        accInfo.add(interestDate);
        accInfo.add(loanId);
        accInfo.add(getDailyInterest());
        accInfo.add(daysInYear);
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
        this.interestId = recordData[0].toString();
        this.nominalAnnualInterestRate = recordData[1].toString();
        this.periodsPerYear = recordData[2].toString();
        this.outstandingPrincipal = recordData[3].toString();
        this.interestDate = recordData[4].toString();
        this.loanId = recordData[5].toString();
        this.dailyInterest = recordData[6].toString();
        this.daysInYear = recordData[7].toString();

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

    @Override
    public Object[] getJournalInfo() {
        Object[] journalObjects = new Object[3];
        journalObjects[0] = new int[]{0, 4, 6, 3, 5};
         journalObjects[1] = new String[]{Main.engine.getProperties().getProperty("loanAccID"), Main.engine.getProperties().getProperty("loanOperationName"), Main.engine.getProperties().getProperty("loanTransactionSide"), Main.engine.getProperties().getProperty("cashAccID")};
        journalObjects[2] = null;

        return journalObjects;

    }

    @Override
    public void postToJournal() throws ParseException, SQLException {
        Journal journal = new Journal(Main.engine.getEntities().get("journal".toLowerCase()), getJournalInfo());
        journal.addJournalEntry(toArrayList());

    }

}
