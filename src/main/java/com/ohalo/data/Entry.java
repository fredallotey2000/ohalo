/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ohalo.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bsystems4
 */
@XmlRootElement
public class Entry {

    @JsonProperty("entry")
    private String data;

    @JsonProperty("indices")
    private List<int[]> indices;

    public Entry(String data, List<int[]> indices) {
        this.data = data;
        this.indices = indices;
    }

    public String getData() {
        return data;
    }

    public List<int[]> getIndices() {
        return indices;
    }

    public void setIndices(List<int[]> indices) {
        this.indices = indices;
    }

    
    
    public void setData(String data) {
        this.data = data;
    }

}
