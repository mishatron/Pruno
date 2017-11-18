package com.hack.apps.starter.util;


public class RatingUtil {
    public static float calculateRate(float location, float service, float comfort) {
        return (location + service + comfort) / 3;
    }
}
