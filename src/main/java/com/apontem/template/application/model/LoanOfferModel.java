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
public class LoanOfferModel implements EntityModel {

    String id;
    String loanId;
    String lenderId;
    String rate;
    String status;
    String createdAt;
    String expiresAt;

    @JsonIgnore
    ArrayList list = null;
    List<Link> links = new ArrayList<Link>();

    public LoanOfferModel(String id, String loanId, String lenderId, String rate, String status, String createdAt, String expiresAt) {
        this.id = id;
        this.loanId = loanId;
        this.lenderId = lenderId;
        this.rate = rate;
        this.status = status;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
    }

    public LoanOfferModel() {

    }

    @Override
    public String getPrimaryKey() {
        return id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getLenderId() {
        return lenderId;
    }

    public void setLenderId(String lenderId) {
        this.lenderId = lenderId;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
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

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public String[] toArray() {

        String[] accInfo = new String[7];
        accInfo[0] = id;
        accInfo[1] = loanId;
        accInfo[2] = lenderId;
        accInfo[3] = rate;
        accInfo[4] = status;
        accInfo[5] = createdAt;
        accInfo[6] = expiresAt;

        return accInfo;
    }

    @Override
    public EntityModel toXMLElement(Object[] recordData) {
        this.id = recordData[0].toString();
        this.loanId = recordData[1].toString();

        this.lenderId = recordData[2].toString();
        this.rate = recordData[3].toString();
        this.status = recordData[4].toString();

        this.createdAt = recordData[5].toString();
        this.expiresAt = recordData[6].toString();

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
