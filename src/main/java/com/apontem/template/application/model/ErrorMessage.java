/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apontem.template.application.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bsystems
 */
@XmlRootElement
public class ErrorMessage {

    int errorID;
    String errorMessage;
    String errorDocumentation;

    public ErrorMessage() {
    }

    public ErrorMessage(int errorID, String errorMessage, String errorDocumentation) {
        this.errorID = errorID;
        this.errorMessage = errorMessage;
        this.errorDocumentation = errorDocumentation;
    }

    public int getErrorID() {
        return errorID;
    }

    public void setErrorID(int errorID) {
        this.errorID = errorID;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDocumentation() {
        return errorDocumentation;
    }

    public void setErrorDocumentation(String errorDocumentation) {
        this.errorDocumentation = errorDocumentation;
    }

}
