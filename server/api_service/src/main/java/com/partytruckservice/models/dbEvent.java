package com.partytruckservice.models;

import java.util.*;
import org.springframework.data.annotation.*;

public class dbEvent {
    private int eventID;
    private String location;
    private Date start_time;
    private Date end_time;
    private int pID;
    private int cID;

    public dbEvent(int eventID, String location, Date start_time, Date end_time, int pID, int cID){
        this.eventID = eventID;
        this.location = location;
        this.start_time = start_time;
        this.end_time = end_time;
        this.pID = pID;
        this.cID = cID;
    }

    public String toString(){
        return "Event [" + eventID + ", " + location + ", " + start_time + ", " + end_time + ", " + pID + ", " + cID + "]";
    }

    public void setEventID(int eventID){
        this.eventID = eventID;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void setStart_Time(Date start_time){
        this.start_time = start_time;
    }

    public void setEnd_Time(Date end_time){
        this.end_time = end_time;
    }

    public void setpID(int pID){
        this.pID = pID;
    }

    public void setcID(int cID){
        this.cID = cID;
    }

    public int getEventID(){
        return eventID;
    }

    public String getLocation(){
        return location;
    }

    public Date getStart_Time(){
        return start_time;
    }

    public Date getEnd_Time(){
        return end_time;
    }

    public int getpID(){
        return pID;
    }

     public int getcID(){
        return cID;
    }
}
