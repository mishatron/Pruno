package com.hack.apps.starter.profile.entity;

import android.net.Uri;

import com.orm.SugarRecord;

public class User extends SugarRecord {

    private Uri imageUri;
    private String username;

    private String token;

    public Uri getImageUri() {
        return imageUri;
    }

    public User() {
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "imageUri=" + imageUri +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

}
