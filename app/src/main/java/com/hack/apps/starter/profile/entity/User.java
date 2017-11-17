package com.hack.apps.starter.profile.entity;

import android.net.Uri;

import com.orm.SugarRecord;

public class User extends SugarRecord {
    private Uri imageUri;
    private String username;
    private Integer gender;

    private String token;

    public Uri getImageUri() {
        return imageUri;
    }

    public User() {
    }

    public User(Uri imageUri, String userName, int gender, float weight, float height, int healthLevel, int maxAlcoholCount) {
        this.imageUri = imageUri;
        this.username = userName;
        this.gender = gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "imageUri=" + imageUri +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", token='" + token + '\'' +
                '}';
    }
}
