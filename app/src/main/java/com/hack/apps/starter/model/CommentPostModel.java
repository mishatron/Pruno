package com.hack.apps.starter.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommentPostModel {
    @SerializedName("place_id")
    @Expose
    private Long entityId;

    @SerializedName("user_name")
    @Expose
    private Long user_name;

    @SerializedName("comfortRate")
    @Expose
    public Float comfortRate;

    @SerializedName("serviceRate")
    @Expose
    public Float serviceRate;

    @SerializedName("locationRate")
    @Expose
    public Float locationRate;


    public CommentPostModel(Long entityId, Long user_name, Float comfortRate, Float serviceRate, Float locationRate) {
        this.entityId = entityId;
        this.user_name = user_name;
        this.comfortRate = comfortRate;
        this.serviceRate = serviceRate;
        this.locationRate = locationRate;
    }
}
