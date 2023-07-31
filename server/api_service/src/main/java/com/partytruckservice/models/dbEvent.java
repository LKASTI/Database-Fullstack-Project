package com.partytruckservice.models;

import java.util.*;
import org.springframework.data.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

public class dbEvent {
    private int eventID;
    private String location;
    private String start_time;
    private String end_time;
    private int pID;
    private int cID;

    public dbEvent(int eventID, String location, String start_time, String end_time, int pID, int cID){
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

    public void setStart_Time(String start_time){
        this.start_time = start_time;
    }

    public void setEnd_Time(String end_time){
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

    public String getStart_Time(){
        return start_time;
    }

    public String getEnd_Time(){
        return end_time;
    }

    public int getpID(){
        return pID;
    }

     public int getcID(){
        return cID;
    }

   


    
}
