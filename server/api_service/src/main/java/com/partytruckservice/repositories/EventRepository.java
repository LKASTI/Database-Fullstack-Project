package com.partytruckservice.repositories;

import com.partytruckservice.models.Item;
import com.partytruckservice.models.dbEvent;

import java.util.*;

import org.springframework.web.bind.annotation.RequestBody;

public interface EventRepository {
    
    int count();

    int save(dbEvent event);

    int updateEventCustomer(int eventID, int cID);
    
    int updateEventPackage(int eventID, int pID);
     
    int deleteById(int id);

    List<dbEvent> getAllEvents();

    public boolean eventTimeConflict(String start_time, String end_time);
   
    public List<dbEvent> getEventForCustomer(int cID);
}
