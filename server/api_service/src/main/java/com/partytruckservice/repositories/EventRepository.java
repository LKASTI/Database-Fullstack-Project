package com.partytruckservice.repositories;

import com.partytruckservice.models.Item;
import com.partytruckservice.models.dbEvent;

import java.util.List;
import java.util.Optional;

public interface EventRepository {
    
    int count();

    int save(dbEvent event);

    int updateEventCustomer(int eventID, int cID);
    
    int updateEventPackage(int eventID, int pID);
     
    int deleteById(int id);

    List<dbEvent> getAllEvents();

   
}
