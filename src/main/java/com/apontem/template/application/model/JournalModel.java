/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apontem.template.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Bsystems4
 */
public interface JournalModel {

    @JsonIgnore
    public Object[] getJournalInfo();

    @JsonIgnore
    public ArrayList<String> toArrayList();

    @JsonIgnore
    public void postToJournal() throws ParseException,SQLException;

}
