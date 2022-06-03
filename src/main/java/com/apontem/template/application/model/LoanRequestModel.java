/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apontem.template.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bsystems
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoanRequestModel implements EntityModel {

    String id;
    String borrowerId;
    String principal;
    String term;
    String minRate;
    String maxRate;
    String reason;
    String status;
    String createdAt;
    String acceptedRate;
    String apontemFee;
    String lenderFee;
    String interestCommisionRate;
    String penalRate;

    @JsonIgnore
    ArrayList list = null;

    List<Link> links = new ArrayList<Link>();

    public LoanRequestModel() {
    }

    public LoanRequestModel(String id, String borrowerId, String principal, String term, String minRate, String maxRate, String reason, String status, String createdAt, String acceptedRate, String apontemFee, String lenderFee, String interestCommisionRate, String penalRate) {
        this.id = id;
        this.borrowerId = borrowerId;
        this.principal = principal;
        this.term = term;
        this.minRate = minRate;
        this.maxRate = maxRate;
        this.reason = reason;
        this.status = status;
        this.createdAt = createdAt;
        this.acceptedRate = acceptedRate;
        this.apontemFee = apontemFee;
        this.lenderFee = lenderFee;
        this.interestCommisionRate = interestCommisionRate;
        this.penalRate = penalRate;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getPrimaryKey() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getMinRate() {
        return minRate;
    }

    public void setMinRate(String minRate) {
        this.minRate = minRate;
    }

    public String getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(String maxRate) {
        this.maxRate = maxRate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAcceptedRate() {
        return acceptedRate;
    }

    public void setAcceptedRate(String acceptedRate) {
        this.acceptedRate = acceptedRate;
    }

    public String getApontemFee() {
        return apontemFee;
    }

    public void setApontemFee(String apontemFee) {
        this.apontemFee = apontemFee;
    }

    public String getLenderFee() {
        return lenderFee;
    }

    public void setLenderFee(String lenderFee) {
        this.lenderFee = lenderFee;
    }

    public String getInterestCommisionRate() {
        return interestCommisionRate;
    }

    public void setInterestCommisionRate(String interestCommisionRate) {
        this.interestCommisionRate = interestCommisionRate;
    }

    public String getPenalRate() {
        return penalRate;
    }

    public void setPenalRate(String penalRate) {
        this.penalRate = penalRate;
    }

    @Override
    public String[] toArray() {

        String[] accInfo = new String[14];
        accInfo[0] = id;
        accInfo[1] = borrowerId;
        accInfo[2] = principal;
        accInfo[3] = term;
        accInfo[4] = minRate;
        accInfo[5] = maxRate;
        accInfo[6] = reason;

        accInfo[7] = status;
        accInfo[8] = createdAt;
        accInfo[9] = acceptedRate;
        accInfo[10] = apontemFee;
        accInfo[11] = lenderFee;
        accInfo[12] = interestCommisionRate;
        accInfo[13] = penalRate;

        return accInfo;
    }

    @Override
    public EntityModel toXMLElement(Object[] recordData) {
        this.id = recordData[0].toString();
        this.borrowerId = recordData[1].toString();

        this.principal = recordData[2].toString();
        this.term = recordData[3].toString();
        this.minRate = recordData[4].toString();

        this.maxRate = recordData[5].toString();
        this.reason = recordData[6].toString();
        this.status = recordData[7].toString();

        this.createdAt = recordData[8].toString();
        this.acceptedRate = recordData[9].toString();
        this.apontemFee = recordData[10].toString();
        this.lenderFee = recordData[11].toString();

        this.interestCommisionRate = recordData[12].toString();
        this.penalRate = recordData[13].toString();

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

    @XmlTransient
    public void addLink(String url, String rel) {
        Link link = new Link(url, rel);
        this.links.add(link);
    }

    public List<Link> getLinks() {
        return links;
    }

}
