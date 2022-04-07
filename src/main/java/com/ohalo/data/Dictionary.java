/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ohalo.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Bsystems4
 */
@Entity
@Table(name = "dictionaries")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dictionary implements EntityModel, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Transient
    private String[] entries;

    @JsonIgnore
    @Column(name = "entries")
    private String entriesStr;

    @Column(name = "is_case_sensitive")
    private boolean is_case_sensitive;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String[] getEntries() {
        if (entriesStr == null) {
            return entries;
        } else {
            String[] split = entriesStr.split(";");
            return split;
        }
    }

    public void setEntries(String[] entries) {
        if (entries != null) {
            StringBuilder buildStr = new StringBuilder();
            for (String str : entries) {
                buildStr.append(str);
                buildStr.append(";");
            }
            entriesStr = buildStr.toString();
        }
        this.entries = entries;
    }

    public String getEntriesStr() {
        return entriesStr;
    }

    public void setEntriesStr(String entriesStr) {
        this.entriesStr = entriesStr;
    }

    public boolean isIs_case_sensitive() {
        return is_case_sensitive;
    }

    public void setIs_case_sensitive(boolean is_case_sensitive) {
        this.is_case_sensitive = is_case_sensitive;
    }

}
