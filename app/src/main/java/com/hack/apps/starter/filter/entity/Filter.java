package com.hack.apps.starter.filter.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Filter implements Serializable {

    @SerializedName("workAtNight")
    @Expose
    private Boolean workAtNight = false;

    @SerializedName("minPrice")
    @Expose
    private Float minPrice;

    @SerializedName("maxPrice")
    @Expose
    private Float maxPrice;

    @SerializedName("minComfortRate")
    @Expose
    private Float minComfortRate = 0.0f;

    @SerializedName("maxComfortRate")
    @Expose
    private Float maxComfortRate = 10.0f;

    @SerializedName("minServiceRate")
    @Expose
    private Float minServiceRate = 0.0f;

    @SerializedName("maxServiceRate")
    @Expose
    private Float maxServiceRate = 10.0f;

    @SerializedName("minLocationRate")
    @Expose
    private Float minLocationRate = 0.0f;

    @SerializedName("maxLocationRate")
    @Expose
    private Float maxLocationRate = 10.0f;

    @SerializedName("tags")
    @Expose
    private List<String> tags = new ArrayList<>();

    public Filter(int min, int max) {
        this.minPrice = (float) min;
        this.maxPrice = (float) max;
    }

    public Boolean getWorkAtNight() {
        return workAtNight;
    }

    public void setWorkAtNight(Boolean workAtNight) {
        this.workAtNight = workAtNight;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Float getMinComfortRate() {
        return minComfortRate;
    }

    public void setMinComfortRate(Float minComfortRate) {
        this.minComfortRate = minComfortRate;
    }

    public Float getMaxComfortRate() {
        return maxComfortRate;
    }

    public void setMaxComfortRate(Float maxComfortRate) {
        this.maxComfortRate = maxComfortRate;
    }

    public Float getMinServiceRate() {
        return minServiceRate;
    }

    public void setMinServiceRate(Float minServiceRate) {
        this.minServiceRate = minServiceRate;
    }

    public Float getMaxServiceRate() {
        return maxServiceRate;
    }

    public void setMaxServiceRate(Float maxServiceRate) {
        this.maxServiceRate = maxServiceRate;
    }

    public Float getMinLocationRate() {
        return minLocationRate;
    }

    public void setMinLocationRate(Float minLocationRate) {
        this.minLocationRate = minLocationRate;
    }

    public Float getMaxLocationRate() {
        return maxLocationRate;
    }

    public void setMaxLocationRate(Float maxLocationRate) {
        this.maxLocationRate = maxLocationRate;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "workAtNight=" + workAtNight +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", minComfortRate=" + minComfortRate +
                ", maxComfortRate=" + maxComfortRate +
                ", minServiceRate=" + minServiceRate +
                ", maxServiceRate=" + maxServiceRate +
                ", minLocationRate=" + minLocationRate +
                ", maxLocationRate=" + maxLocationRate +
                ", tags=" + tags +
                '}';
    }

}
