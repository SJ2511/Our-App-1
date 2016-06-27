package com.example.dell.intents;

/**
 * Created by DELL on 6/27/2016.
 */
public class Timetable {

    private String course,type,faculty,venue, time,tvariable;
    public Timetable()
    {

    }
    public Timetable(String course, String type, String faculty,String venue,String time)
    {
        this.course=course;
        this.type=type;
        this.venue=venue;
        this.faculty=faculty;
        this.time= time;

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time= time;
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
}
