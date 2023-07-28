package com.partytruckservice.repositories;

import com.partytruckservice.models.Item;
import com.partytruckservice.models.dbEvent;

import java.util.List;
import java.util.Optional;

public interface EventRepository {
    
    int count();

    int save(dbEvent event);

    int deleteById(int id);

    List<dbEvent> getAllEvents();

   
}
