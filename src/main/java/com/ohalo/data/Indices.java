/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ohalo.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bsystems4
 */
@XmlRootElement
public class Indices implements Serializable {

    @JsonProperty("indices")
    private List<int[]> indices;

    public Indices(List<int[]> indices) {
        this.indices = indices;
    }

    public List<int[]> getIndices() {
        return indices;
    }

    public void setIndices(List<int[]> indices) {
        this.indices = indices;
    }

}
