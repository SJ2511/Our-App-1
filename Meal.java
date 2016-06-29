package com.example.dell.intents;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 6/28/2016.
 */
public class Meal {

    private String mealType, fromtime, totime;
    int icon_id;

    public Meal() {

    }

    public Meal(String mealType, String fromtime, String totime, int icon_id) {
        this.icon_id = icon_id;
        this.fromtime = fromtime;
        this.mealType = mealType;
        this.totime = totime;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getFromtime() {
        return fromtime;
    }

    public void setFromtime(String fromtime) {
        this.fromtime = fromtime;
    }

    public String getTotime() {
        return totime;
    }

    public void setTotime(String totime) {
        this.totime = totime;
    }

    public int getIcon_id() {
        return icon_id;
    }

    public void setIcon_id(int icon_id) {
        this.icon_id = icon_id;
    }


}
