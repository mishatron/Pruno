package com.hack.apps.starter.profile.entity;

import android.net.Uri;

import com.orm.SugarRecord;

public class User extends SugarRecord {
    private Uri imageUri;
    private String userName;
    private Integer gender;


//    private boolean vkLogined;

    private String facebookToken;


    public Uri getImageUri() {
        return imageUri;
    }

    public User() {
    }

    public User(Uri imageUri, String userName, int gender, float weight, float height, int healthLevel, int maxAlcoholCount) {
        this.imageUri = imageUri;
        this.userName = userName;
        this.gender = gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getFacebookToken() {
        return facebookToken;
    }

    public void setFacebookToken(String facebookToken) {
        this.facebookToken = facebookToken;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "userName='" + userName + '\'' +
                ", gender=" + gender +
                '}';
    }

    public boolean isDataSet() {
        return (userName != null &&
                gender != null);
    }


    public void cleaFacebookData() {

        this.facebookToken = null;
    }

}
