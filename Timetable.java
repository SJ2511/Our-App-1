package com.example.dell.intents;

/**
 * Created by DELL on 6/27/2016.
 */
public class Timetable {

    private String course, type, day, faculty, venue, fromtime, totime;
    private boolean mChecked;
    private boolean mActivateExpansion;
    private int id;
    private int position;

    public Timetable() {

    }

    public Timetable(String course, String day, String type, String faculty, String venue, String fromtime, String totime) {
        this.course = course;
        this.type = type;
        this.venue = venue;
        this.faculty = faculty;
        this.fromtime = fromtime;
        this.day = day;

    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isChecked() {
        return mChecked;
    }

    public void setChecked(boolean checked) {
        mChecked = checked;
    }

    public boolean isActivateExpansion() {
        return mActivateExpansion;
    }

    public void setActivateExpansion(boolean activateExpansion) {
        mActivateExpansion = activateExpansion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }
}
