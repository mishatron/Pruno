package com.hack.apps.starter.place.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.io.Serializable;

//{"tags": ["\u0420\u041e\u0411\u041e\u0422\u0410"], "pricePerHour": 5.0, "photos": ["/upload/images/info64.png"], "address": "\u043d\u0435 \u0441\u043a\u0430\u0436\u0443", "pricePerDay": 5.0, "longitude": 4.0, "description": "\u043c\u0456\u0439 \u0433\u0430\u0440\u0430\u0436", "icon": "/upload/images/VBIF512.png", "serviceRate": 0.0, "locationRate": 0.0, "comfortRate": 0.0, "latitude": 5.0, "comments": [], "title": "\u0413\u0430\u0440\u0430\u0436", "workAtNight": false}


public class Place extends SugarRecord implements Serializable {

    @SerializedName("place_id")
    @Expose
    public Long id;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("icon")
    @Expose
    public String icon;

    @SerializedName("description")
    @Expose
    public String description;

    @SerializedName("longitude")
    @Expose
    public Double longitude;

    @SerializedName("latitude")
    @Expose
    public Double latitude;

    @SerializedName("pricePerHour")
    @Expose
    public Double pricePerHour;

    @SerializedName("photos")
    @Expose
    public String[] photos;

    @SerializedName("comfortRate")
    @Expose
    public Float comfortRate;

    @SerializedName("serviceRate")
    @Expose
    public Float serviceRate;

    @SerializedName("locationRate")
    @Expose
    public Float locationRate;

    @SerializedName("tags")
    @Expose
    public String[] tags;

    @SerializedName("workAtNight")
    @Expose
    public Boolean workAtNight;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getWorkAtNight() {
        return workAtNight;
    }

    public void setWorkAtNight(Boolean workAtNight) {
        this.workAtNight = workAtNight;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public String[] getPhotos() {
        return photos;
    }

    public void setPhotos(String[] photos) {
        this.photos = photos;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}
