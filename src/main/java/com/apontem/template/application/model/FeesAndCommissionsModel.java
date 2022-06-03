/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apontem.template.application.model;

import apps.mobile.engine.Journal;
import com.bvirtual.engine.Main;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bsystems
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeesAndCommissionsModel implements EntityModel,JournalModel {

    private String feeId;
    private String transactinDate;
    private String loanId;
    private String lenderFeeRate;
    private String lenderFeeAmount;
    private String apontemFeeRate;
    private String apontemFeeAmount;
    private String remark;

    ArrayList list = null;

    public FeesAndCommissionsModel() {
    }

    public String getFeeId() {
        return feeId;
    }

    public void setFeeId(String feeId) {
        this.feeId = feeId;
    }

    public String getTransactinDate() {
        return transactinDate;
    }

    public void setTransactinDate(String transactinDate) {
        this.transactinDate = transactinDate;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getLenderFeeRate() {
        return lenderFeeRate;
    }

    public void setLenderFeeRate(String lenderFeeRate) {
        this.lenderFeeRate = lenderFeeRate;
    }

    public String getLenderFeeAmount() {
        return lenderFeeAmount;
    }

    public void setLenderFeeAmount(String lenderFeeAmount) {
        this.lenderFeeAmount = lenderFeeAmount;
    }

    public String getApontemFeeRate() {
        return apontemFeeRate;
    }

    public void setApontemFeeRate(String apontemFeeRate) {
        this.apontemFeeRate = apontemFeeRate;
    }

    public String getApontemFeeAmount() {
        return apontemFeeAmount;
    }

    public void setApontemFeeAmount(String apontemFeeAmount) {
        this.apontemFeeAmount = apontemFeeAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String[] toArray() {

        String[] accInfo = new String[7];
        accInfo[0] = feeId;
        accInfo[1] = transactinDate;
        accInfo[2] = loanId;
        accInfo[3] = lenderFeeRate;
        accInfo[4] = lenderFeeAmount;
        accInfo[5] = apontemFeeRate;
        accInfo[6] = apontemFeeAmount;

        accInfo[7] = remark;

        return accInfo;

    }
    
    
    
      @Override
    public Object[] getJournalInfo() {
        Object[] journalObjects = new Object[3];

        journalObjects[0] = new int[]{0,1, 9, 11, 12};
        journalObjects[1] = new String[]{Main.engine.getProperties().getProperty("loanAccID"), Main.engine.getProperties().getProperty("loanOperationName"), Main.engine.getProperties().getProperty("loanTransactionSide"), Main.engine.getProperties().getProperty("cashAccID")};
        journalObjects[2] = null;

        return journalObjects;
    }

    @Override
    public String getPrimaryKey() {
        return feeId;
    }

    @Override
    public EntityModel toXMLElement(Object[] recordData) {
        this.feeId = recordData[0].toString();
        this.transactinDate = recordData[1].toString();
        this.loanId = recordData[2].toString();
        this.lenderFeeRate = recordData[3].toString();
        this.lenderFeeAmount = recordData[4].toString();
        this.apontemFeeRate = recordData[5].toString();
        this.apontemFeeAmount = recordData[6].toString();
        this.remark = recordData[7].toString();
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
    public ArrayList<String> toArrayList() {
        ArrayList<String> accInfo = new ArrayList<String>();
//        accInfo.add(loanId);
//        accInfo.add(approvedDate);
//        accInfo.add(approvedBy);
//        accInfo.add(customerAccountId);
//        accInfo.add(processingFee);
//        accInfo.add(nominalAnnualInterestRate);
//        accInfo.add(periodsPerYear);
//        accInfo.add(startDate);
//        accInfo.add(montlyPayments);
//        accInfo.add(principal);
//        accInfo.add(numberOfPayments);
//        accInfo.add("LN " + principal + " ON " + approvedDate);
//        accInfo.add(loanId);
//        accInfo.add(lastupdatedate);
//        accInfo.add(lastupdateby);

        return accInfo;
    }

    @Override
    public void postToJournal() throws SQLException, ParseException {
//       try {
//            Journal journal = new Journal(Main.engine.getEntities().get("Journal"),getJournalInfo());
//            journal.addJournalEntry(toArrayList());
//        } catch (ParseException ex) {
//            Logger.getLogger(DailyInterestModel.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(LoanModel.class.getName()).log(Level.SEVERE, null, ex);
//        }

        Journal journal = new Journal(Main.engine.getEntities().get("journal"), getJournalInfo());
        journal.addJournalEntry(toArrayList());

    }

}
