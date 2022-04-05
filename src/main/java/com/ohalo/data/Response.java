/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ohalo.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bsystems4
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    @JsonProperty("recordId")
    private long recordId;

    @JsonProperty("message")
    private String message;

    @JsonProperty("operation")
    private String operation;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("entity")
    private String entity;

    private EntityModel data;

    public static Response deleteSuccess = new Response("successful", "DELETE", true);
    public static Response deleteFail = new Response("DELETE", false);
    public static Response createSuccess = new Response("successful", "CREATE", true);
    public static Response createFail = new Response("CREATE", false);
    public static Response updateSuccess = new Response("successful", "UPDATE", true);
    public static Response updateFail = new Response("UPDATE", false);

    public Response(String message, String operation, boolean success) {
        this.message = message;
        this.operation = operation;
        this.success = success;
    }

    public Response(String operation, boolean success) {
        this.operation = operation;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public long getRecordId() {
        return recordId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    public EntityModel getData() {
        return data;
    }

    public void setData(EntityModel data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
