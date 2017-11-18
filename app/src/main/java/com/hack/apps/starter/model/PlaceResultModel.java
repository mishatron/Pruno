package com.hack.apps.starter.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
//{"results": [{"comfortRate": 0.0, "tags": ["1", "2"], "serviceRate": 0.0, "icon": "/upload/images/gp.png", "title": "\u0430\u0440\u0442\u0438\u043d\u043e\u0432", "locationRate": 0.0, "place_id": 1}, {"comfortRate": 0.0, "tags": [], "serviceRate": 0.0, "title": "\u0433\u0430\u0440\u0430\u0436", "locationRate": 0.0, "place_id": 2}]}

public class PlaceResultModel implements Serializable{
    @SerializedName("results")
    @Expose
    private List<PlaceModel> results;

    public List<PlaceModel> getResults() {
        return results;
    }
}
