package com.hack.apps.starter.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hack.apps.starter.util.RatingUtil;

import java.io.Serializable;
import java.util.Arrays;
//{"comfortRate": 0.0, "tags": ["1", "2"],
// "serviceRate": 0.0, "icon": "/upload/images/gp.png",
// "title": "\u0430\u0440\u0442\u0438\u043d\u043e\u0432", "locationRate": 0.0, "place_id": 1}

public class PlaceModel implements Serializable {
    private float midRate;

    @SerializedName("place_id")
    @Expose
    private int place_id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("icon")
    @Expose
    private String icon;

    @SerializedName("tags")
    @Expose
    private String[] tags;

    @SerializedName("comfortRate")
    @Expose
    private float comfortRate;

    @SerializedName("serviceRate")
    @Expose
    private float serviceRate;

    @SerializedName("locationRate")
    @Expose
    private float locationRate;


    @Override
    public String toString() {
        return "PlaceModel{" +
                "place_id=" + place_id +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", comfortRate=" + comfortRate +
                ", serviceRate=" + serviceRate +
                ", locationRate=" + locationRate +
                '}';
    }

    public int getPlace_id() {
        return place_id;
    }

    public String getTitle() {
        return title;
    }

    public String getIcon() {
        return icon;
    }

    public String[] getTags() {
        return tags;
    }

    public float getComfortRate() {
        return comfortRate;
    }

    public float getServiceRate() {
        return serviceRate;
    }

    public float getLocationRate() {
        return locationRate;
    }

    public PlaceModel(int place_id, String title, String icon, String[] tags, float comfortRate, float serviceRate, float locationRate) {
        this.place_id = place_id;
        this.title = title;
        this.icon = icon;
        this.tags = tags;
        this.comfortRate = comfortRate;
        this.serviceRate = serviceRate;
        this.locationRate = locationRate;
        midRate = RatingUtil.calculateRate(locationRate, serviceRate, comfortRate);
    }


    public float getMidRate() {
        return midRate;
    }
}
