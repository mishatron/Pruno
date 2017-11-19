package com.hack.apps.starter.util;


import android.graphics.Color;

import com.hack.apps.starter.R;

public enum Tag {

    WORK(R.drawable.ic_tag_work, Color.rgb(200, 0, 0), "РОБОТА"),
    REST(R.drawable.ic_tag_rest, Color.rgb(255, 156, 64), "ВІДПОЧИНОК"),
    FOOD(R.drawable.ic_tag_food, Color.rgb(0, 0, 200), "ЇЖА"),
    WIFI(R.drawable.ic_tag_wifi, Color.rgb(0, 180, 0), "WI-FI");

    private int image;
    private int color;
    private String title;

    Tag(int image, int color, String title) {
        this.image = image;
        this.color = color;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
