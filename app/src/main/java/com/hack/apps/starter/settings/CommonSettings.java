package com.hack.apps.starter.settings;


import com.orm.SugarRecord;

public class CommonSettings extends SugarRecord {


    private Boolean firstUse;


    public Boolean isFirstUse() {
        return firstUse;
    }

    public void setFirstUse(Boolean firstUse) {
        this.firstUse = firstUse;
    }

    public void performFirstUse() {
        this.firstUse = false;
    }


}
