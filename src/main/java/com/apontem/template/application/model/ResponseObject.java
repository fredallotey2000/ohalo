/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apontem.template.application.model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bsystems
 */
@XmlRootElement
public class ResponseObject implements EntityModel {

    public static final String SUCCESS = "success";
    public static final String FAILURE = "failed";

    String recordId;
    boolean success;
    String message;
    String entity;
    String operation;

    public ResponseObject(String recordId, boolean success, String message, String entity, String operation) {
        if (recordId == null) {
            this.recordId = "";
        } else {
            this.recordId = recordId;
        }
        this.success = success;
        this.message = message;
        this.entity = entity;
        this.operation = operation;
    }

    public static ResponseObject defaultFailure(String exception, String entityName, String operation) {
        return new ResponseObject(
                null,
                false,
                exception,
                entityName,
                operation);
    }

     public static ResponseObject defaultSuccess(String entityName, String operation) {
        return new ResponseObject(
                null,
                true,
                "success",
                entityName,
                operation);
    }
     
    public ResponseObject() {
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    @XmlTransient
    public String[] toArray() {
        return null;

    }

    @Override
    @XmlTransient
    public String getPrimaryKey() {
        return null;
    }

    @Override
    @XmlTransient
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
