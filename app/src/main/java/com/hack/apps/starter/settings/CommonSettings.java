package com.hack.apps.starter.settings;


import com.orm.SugarRecord;

public class CommonSettings extends SugarRecord {


    private Boolean firstUse;

    private Boolean userLoggined;

    private Long userId;

    public Boolean isUserLoggined() {
        return userLoggined;
    }

    public void setUserLoggined(Boolean userLoggined) {
        this.userLoggined = userLoggined;
    }


    public Boolean isFirstUse() {
        return firstUse;
    }

    public void setFirstUse(Boolean firstUse) {
        this.firstUse = firstUse;
    }

    public void performFirstUse() {
        this.firstUse = false;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
