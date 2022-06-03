/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apontem.template.application.model;

import apps.mobile.engine.Journal;
import com.bvirtual.api.service.Service;
import com.bvirtual.engine.Main;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bsystems
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoanModel implements EntityModel, JournalModel {

    private String loanId;
    private String approvedDate;
    private String approvedBy;
    private String customerAccountId;
    private String processingFee;
    private String nominalAnnualInterestRate;
    private String periodsPerYear;
    private String startDate;
    private String principal;
    private String montlyPayments;
    private String numberOfPayments;
    private String status;
    private String lastupdatedate;
    private String lastupdateby;
    private String loanType;
    ArrayList list = null;

    public LoanModel() {
    }

    public LoanModel(String loanId, String approvedDate, String approvedBy, String customerAccountId, String processingFee, String nominalAnnualInterestRate, String periodsPerYear, String startDate, String principal, String montlyPayments, String numberOfPayments, String status, String lastupdatedate, String lastupdateby, String loanType) {
        this.loanId = loanId;
        this.approvedDate = approvedDate;
        this.approvedBy = approvedBy;
        this.customerAccountId = customerAccountId;
        this.processingFee = processingFee;
        this.nominalAnnualInterestRate = nominalAnnualInterestRate;
        this.periodsPerYear = periodsPerYear;
        this.startDate = startDate;
        this.principal = principal;
        this.montlyPayments = montlyPayments;
        this.numberOfPayments = numberOfPayments;
        this.status = status;
        this.lastupdatedate = lastupdatedate;
        this.lastupdateby = lastupdateby;
        this.loanType = loanType;
    }

    @GET
    @Path("{loanid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLoanOffer(
            @PathParam("loanid") String loanid,
            @Context UriInfo uriInfo) {
        LoanModel loanOfferModel2 = (LoanModel) Service.CRUDEntity(
                "Loan",
                Main.READ_OPERATION,
                new LoanModel(),
                null,
                new int[]{0},
                new String[]{loanid},
                null,
                null
        );
        return Response.ok(loanOfferModel2).build();
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(String approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getCustomerAccountId() {
        return customerAccountId;
    }

    public void setCustomerAccountId(String customerAccountId) {
        this.customerAccountId = customerAccountId;
    }

    public String getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(String processingFee) {
        this.processingFee = processingFee;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getMontlyPayments() {
        return montlyPayments;
    }

    public void setMontlyPayments(String montlyPayments) {

        double principal_ = Double.parseDouble(principal);
        double rate = ((Double.parseDouble(nominalAnnualInterestRate) / 100)
                / Double.parseDouble(periodsPerYear));
        int time = Integer.parseInt(numberOfPayments);
        double p = (principal_ * rate) / (1 - Math.pow(1 + rate, -time));
        this.montlyPayments = Double.toString(p);

    }

    public String getNumberOfPayments() {
        return numberOfPayments;
    }

    public void setNumberOfPayments(String numberOfPayments) {
        this.numberOfPayments = numberOfPayments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastupdatedate() {
        return lastupdatedate;
    }

    public void setLastupdatedate(String lastupdatedate) {
        this.lastupdatedate = lastupdatedate;
    }

    public String getLastupdateby() {
        return lastupdateby;
    }

    public void setLastupdateby(String lastupdateby) {
        this.lastupdateby = lastupdateby;
    }

    @Override
    @XmlTransient
    public String[] toArray() {
        String[] accInfo = new String[15];
        accInfo[0] = loanId;
        accInfo[1] = approvedDate;
        accInfo[2] = approvedBy;
        accInfo[3] = customerAccountId;
        accInfo[4] = processingFee;
        accInfo[5] = nominalAnnualInterestRate;
        accInfo[6] = periodsPerYear;
        accInfo[7] = startDate;
        accInfo[8] = principal;
        accInfo[9] = montlyPayments;
        accInfo[10] = numberOfPayments;
        accInfo[11] = status;
        accInfo[12] = lastupdatedate;
        accInfo[13] = lastupdateby;
        accInfo[14] = lastupdateby;

        return accInfo;
    }

    @Override
    @XmlTransient
    public String getPrimaryKey() {
        return loanId;
    }

    @Override
    @XmlTransient
    public EntityModel toXMLElement(Object[] recordData) {

        this.loanId = recordData[0].toString();
        this.approvedDate = recordData[1].toString();
        this.approvedBy = recordData[2].toString();

        this.customerAccountId = recordData[3].toString();
        this.processingFee = recordData[4].toString();
        this.nominalAnnualInterestRate = recordData[5].toString();
        this.periodsPerYear = recordData[6].toString();
        this.startDate = recordData[7].toString();
        this.principal = recordData[8].toString();
        this.montlyPayments = recordData[9].toString();
        this.numberOfPayments = recordData[10].toString();
        this.status = recordData[11].toString();
        this.lastupdatedate = recordData[12].toString();
        this.lastupdateby = recordData[13].toString();
        this.loanType = recordData[14].toString();

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

        journalObjects[0] = new int[]{0, 1, 9, 11, 12};
        journalObjects[1] = new String[]{Main.engine.getProperties().getProperty("loanAccID"), Main.engine.getProperties().getProperty("loanOperationName"), Main.engine.getProperties().getProperty("loanTransactionSide"), Main.engine.getProperties().getProperty("cashAccID")};
        journalObjects[2] = null;

        return journalObjects;
    }

    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> accInfo = new ArrayList<String>();
        accInfo.add(loanId);
        accInfo.add(approvedDate);
        accInfo.add(approvedBy);
        accInfo.add(customerAccountId);
        accInfo.add(processingFee);
        accInfo.add(nominalAnnualInterestRate);
        accInfo.add(periodsPerYear);
        accInfo.add(startDate);
        accInfo.add(montlyPayments);
        accInfo.add(principal);
        accInfo.add(numberOfPayments);
        accInfo.add("LN " + principal + " ON " + approvedDate);
        accInfo.add(loanId);
        accInfo.add(lastupdatedate);
        accInfo.add(lastupdateby);

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
