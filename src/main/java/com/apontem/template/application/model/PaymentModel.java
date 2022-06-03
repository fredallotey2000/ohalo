/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apontem.template.application.model;

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
public class PaymentModel implements EntityModel {

    String apiKey;
    String applicationName;
    String country;
    String bank;
    String thirdPartyProcessor;
    String paymentGateway;

    String transactionReferenceId;
    String transactionDate;
    String transactionDescription;
    String transactionAmount;
    String transactionType;
    String transactionFee;
    String transactionStatus;
    String transactionRemarks;

    String mobileNetwork;
    String mobileNumber;
    String mobileAccountHolderName;
    String mobileCharges;
    String mobileReferenceCode;

    String bankCode;
    String bankName;
    String accountNumber;
    String accountName;
    String bankCharge;
    String bankReferenceCode;
    String lastUpdateDate;

    ArrayList list = null;
    List<Link> links = new ArrayList<Link>();

    public PaymentModel(String applicationName, String country, String bank, String thirdPartyProcessor, String paymentGateway, String transactionReferenceId, String transactionDate, String transactionDescription, String transactionAmount, String transactionType, String transactionFee, String transactionStatus, String transactionRemarks, String mobileNetwork, String mobileNumber, String mobileAccountHolderName, String mobileCharges, String mobileReferenceCode, String bankCode, String bankName, String accountNumber, String accountName, String bankCharge, String bankReferenceCode, String lastUpdateDate, String apiKey) {
        this.applicationName = applicationName;
        this.country = country;
        this.bank = bank;
        this.thirdPartyProcessor = thirdPartyProcessor;
        this.paymentGateway = paymentGateway;
        this.transactionReferenceId = transactionReferenceId;
        this.transactionDate = transactionDate;
        this.transactionDescription = transactionDescription;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
        this.transactionFee = transactionFee;
        this.transactionStatus = transactionStatus;
        this.transactionRemarks = transactionRemarks;
        this.mobileNetwork = mobileNetwork;
        this.mobileNumber = mobileNumber;
        this.mobileAccountHolderName = mobileAccountHolderName;
        this.mobileCharges = mobileCharges;
        this.mobileReferenceCode = mobileReferenceCode;
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.bankCharge = bankCharge;
        this.bankReferenceCode = bankReferenceCode;
        this.lastUpdateDate = lastUpdateDate;
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public PaymentModel() {

    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getThirdPartyProcessor() {
        return thirdPartyProcessor;
    }

    public void setThirdPartyProcessor(String thirdPartyProcessor) {
        this.thirdPartyProcessor = thirdPartyProcessor;
    }

    public String getPaymentGateway() {
        return paymentGateway;
    }

    public void setPaymentGateway(String paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String getTransactionReferenceId() {
        return transactionReferenceId;
    }

    public void setTransactionReferenceId(String transactionReferenceId) {
        this.transactionReferenceId = transactionReferenceId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(String transactionFees) {
        this.transactionFee = transactionFees;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionRemarks() {
        return transactionRemarks;
    }

    public void setTransactionRemarks(String transactionRemarks) {
        this.transactionRemarks = transactionRemarks;
    }

    public String getMobileNetwork() {
        return mobileNetwork;
    }

    public void setMobileNetwork(String mobileNetwork) {
        this.mobileNetwork = mobileNetwork;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileAccountHolderName() {
        return mobileAccountHolderName;
    }

    public void setMobileAccountHolderName(String mobileAccountHolderName) {
        this.mobileAccountHolderName = mobileAccountHolderName;
    }

    public String getMobileCharges() {
        return mobileCharges;
    }

    public void setMobileCharges(String mobileCharges) {
        this.mobileCharges = mobileCharges;
    }

    public String getMobileReferenceCode() {
        return mobileReferenceCode;
    }

    public void setMobileReferenceCode(String mobileReferenceCode) {
        this.mobileReferenceCode = mobileReferenceCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankCharge() {
        return bankCharge;
    }

    public void setBankCharge(String bankCharge) {
        this.bankCharge = bankCharge;
    }

    public String getBankReferenceCode() {
        return bankReferenceCode;
    }

    public void setBankReferenceCode(String bankReferenceCode) {
        this.bankReferenceCode = bankReferenceCode;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String getPrimaryKey() {
        return null;
    }

    @Override
    public String[] toArray() {
        String[] accInfo = new String[26];
        accInfo[0] = applicationName;
        accInfo[1] = country;
        accInfo[2] = bank;
        accInfo[3] = thirdPartyProcessor;
        accInfo[4] = paymentGateway;

        accInfo[5] = transactionReferenceId;
        accInfo[6] = transactionDate;
        accInfo[7] = transactionDescription;
        accInfo[8] = transactionAmount;
        accInfo[9] = transactionType;
        accInfo[10] = transactionFee;
        accInfo[11] = transactionStatus;
        accInfo[12] = transactionRemarks;

        accInfo[13] = mobileNetwork;
        accInfo[14] = mobileNumber;
        accInfo[15] = mobileAccountHolderName;
        accInfo[16] = mobileCharges;
        accInfo[17] = mobileReferenceCode;

        accInfo[18] = bankCode;
        accInfo[19] = bankName;
        accInfo[20] = accountNumber;
        accInfo[21] = accountName;

        accInfo[22] = bankCharge;
        accInfo[23] = bankReferenceCode;
        accInfo[24] = lastUpdateDate;
        accInfo[25] = apiKey;

        return accInfo;
    }

    @Override
    public EntityModel toXMLElement(Object[] recordData) {
        applicationName = recordData[0].toString();
        country = recordData[1].toString();
        bank = recordData[2].toString();
        thirdPartyProcessor = recordData[3].toString();
        paymentGateway = recordData[4].toString();

        transactionReferenceId = recordData[5].toString();
        transactionDate = recordData[6].toString();
        transactionDescription = recordData[7].toString();
        transactionAmount = recordData[8].toString();
        transactionType = recordData[9].toString();
        transactionFee = recordData[10].toString();
        transactionStatus = recordData[11].toString();
        transactionRemarks = recordData[12].toString();

        mobileNetwork = recordData[13].toString();
        mobileNumber = recordData[14].toString();
        mobileAccountHolderName = recordData[15].toString();
        mobileCharges = recordData[16].toString();
        mobileReferenceCode = recordData[17].toString();

        bankCode = recordData[18].toString();
        bankName = recordData[19].toString();
        accountNumber = recordData[20].toString();
        accountName = recordData[21].toString();

        bankCharge = recordData[22].toString();
        bankReferenceCode = recordData[23].toString();
        lastUpdateDate = recordData[24].toString();
        apiKey = recordData[25].toString();

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
