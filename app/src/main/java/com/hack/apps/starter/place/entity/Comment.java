package com.hack.apps.starter.place.entity;

//{"username": "qqq", "msg": "test", "pub_date": "18.11.17 22:46"}

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.io.Serializable;

public class Comment extends SugarRecord implements Serializable {

    @SerializedName("username")
    private String username;

    @SerializedName("msg")
    private String message;

    @SerializedName("pub_date")
    private String date;

    private Float comfortRate;
    private Float serviceRate;
    private Float locationRate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getComfortRate() {
        return comfortRate;
    }

    public void setComfortRate(Float comfortRate) {
        this.comfortRate = comfortRate;
    }

    public Float getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(Float serviceRate) {
        this.serviceRate = serviceRate;
    }

    public Float getLocationRate() {
        return locationRate;
    }

    public void setLocationRate(Float locationRate) {
        this.locationRate = locationRate;
    }
}
