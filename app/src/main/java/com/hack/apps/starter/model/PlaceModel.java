package com.hack.apps.starter.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;
//{"comfortRate": 0.0, "tags": ["1", "2"],
// "serviceRate": 0.0, "icon": "/upload/images/gp.png",
// "title": "\u0430\u0440\u0442\u0438\u043d\u043e\u0432", "locationRate": 0.0, "place_id": 1}

public class PlaceModel implements Serializable {
    private float midRate;

    public Long getPlace_id() {
        return place_id;
    }

    public void setPlace_id(Long place_id) {
        this.place_id = place_id;
    }

    @SerializedName("place_id")
    @Expose
    private Long place_id;

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
    private Float comfortRate;

    @SerializedName("pricePerHour")
    @Expose
    private Float pricePerHour;

    @SerializedName("longitude")
    @Expose
    private Double longitude;

    @SerializedName("latitude")
    @Expose
    private Double latitude;


    public Float getPricePerHour() {
        return pricePerHour;
    }

    @SerializedName("serviceRate")

    @Expose
    private float serviceRate;

    @SerializedName("locationRate")
    @Expose
    private float locationRate;


    @Override
    public String toString() {
        return "PlaceModel{" +
                "midRate=" + midRate +
                ", place_id=" + place_id +
                ", title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", comfortRate=" + comfortRate +
                ", pricePerHour=" + pricePerHour +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", serviceRate=" + serviceRate +
                ", locationRate=" + locationRate +
                '}';
    }

    public void setComfortRate(Float comfortRate) {
        this.comfortRate = comfortRate;
    }

    public void setPricePerHour(Float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setMidRate(float midRate) {
        this.midRate = midRate;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setComfortRate(float comfortRate) {
        this.comfortRate = comfortRate;
    }

    public void setServiceRate(float serviceRate) {
        this.serviceRate = serviceRate;
    }

    public void setLocationRate(float locationRate) {
        this.locationRate = locationRate;
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

    public Float getComfortRate() {
        return comfortRate;
    }

    public Float getServiceRate() {
        return serviceRate;
    }

    public Float getLocationRate() {
        return locationRate;
    }

    public float getMidRate() {
        return midRate;
    }

    public PlaceModel(float midRate, Long place_id, String title, String icon, String[] tags, Float comfortRate, Float pricePerHour, Double longitude, Double latitude, float serviceRate, float locationRate) {
        this.midRate = midRate;
        this.place_id = place_id;
        this.title = title;
        this.icon = icon;
        this.tags = tags;
        this.comfortRate = comfortRate;
        this.pricePerHour = pricePerHour;
        this.longitude = longitude;
        this.latitude = latitude;
        this.serviceRate = serviceRate;
        this.locationRate = locationRate;
    }
}
