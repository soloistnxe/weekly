package com.springboot.weekly.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Date;

public class Information {
    private Integer id;
    private String informationTitle;
    private String information;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getInformationTitle() {
        return informationTitle;
    }

    public void setInformationTitle(String informationTitle) {
        this.informationTitle = informationTitle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", informationTitle='" + informationTitle + '\'' +
                ", information='" + information + '\'' +
                ", date=" + date +
                '}';
    }
}
