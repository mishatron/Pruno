package com.hack.apps.starter.place.entity;

import com.orm.SugarRecord;

import java.util.List;

public class Place extends SugarRecord {

    private String title;
    private String icon;
    private String description;

    private Double longitude;
    private Double latitude;

    private Double pricePerHour;
    private Double pricePerDay;

    private List<String> photos;

    private Double comfortRate;
    private Double serviceRate; // якість
    private Double locationRate;

    private List<String> tags;


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

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public Double getComfortRate() {
        return comfortRate;
    }

    public void setComfortRate(Double comfortRate) {
        this.comfortRate = comfortRate;
    }

    public Double getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(Double serviceRate) {
        this.serviceRate = serviceRate;
    }

    public Double getLocationRate() {
        return locationRate;
    }

    public void setLocationRate(Double locationRate) {
        this.locationRate = locationRate;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
