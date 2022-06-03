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
public class UserModel implements EntityModel {

    private String id;
    private String uuid;
    private String displayName;
    private String phoneNumber;
    private String user;
    private String status;
    private String createdAt;


    public UserModel() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

   


    @Override
    @XmlTransient
    public String[] toArray() {
        String[] accInfo = new String[7];
        accInfo[0] = id;
        accInfo[1] = uuid;
        accInfo[2] = displayName;
        accInfo[3] = phoneNumber;
       // accInfo[4] = user;
        accInfo[4] = status;
        accInfo[5] = createdAt;
      

        return accInfo;
    }

    @Override
    @XmlTransient
    public String getPrimaryKey() {
        return id;
    }

    @Override
    @XmlTransient
    public EntityModel toXMLElement(Object[] recordData) {

        this.id = recordData[0].toString();
        this.uuid = recordData[1].toString();
        this.displayName = recordData[2].toString();

        this.phoneNumber = recordData[3].toString();
       // this.user = recordData[4].toString();
        this.status = recordData[4].toString();
        this.createdAt = recordData[5].toString();
        

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
