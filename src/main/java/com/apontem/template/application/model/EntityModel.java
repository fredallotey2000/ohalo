/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apontem.template.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;

/**
 *
 * @author Bsystems
 */
public interface EntityModel {

    public String[] toArray();

    @JsonIgnore
    public String getPrimaryKey();

    public EntityModel toXMLElement(Object[] recordData);

    @JsonIgnore
    public void setList(ArrayList<Object[]> records);

    @JsonIgnore
    public ArrayList<Object[]> getList();
    
   

}
