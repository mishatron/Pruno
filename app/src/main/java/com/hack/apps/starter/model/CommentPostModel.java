package com.hack.apps.starter.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommentPostModel {

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("comfortRate")
    @Expose
    public Float comfortRate;

    @SerializedName("serviceRate")
    @Expose
    public Float serviceRate;

    @SerializedName("locationRate")
    @Expose
    public Float locationRate;

    @SerializedName("text")
    @Expose
    public String message;


    public CommentPostModel(String username, String message, Float comfortRate, Float serviceRate, Float locationRate) {
        this.username = username;
        this.message = message;
        this.comfortRate = comfortRate;
        this.serviceRate = serviceRate;
        this.locationRate = locationRate;
    }
}
