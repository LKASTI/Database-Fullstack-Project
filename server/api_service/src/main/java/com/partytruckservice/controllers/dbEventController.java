package com.partytruckservice.controllers;

import com.partytruckservice.models.*;
import com.partytruckservice.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/event")
public class dbEventController {
    //create an item 
    //edit stock of item
    //list all items
    //get item by name

    @Autowired
    private JdbcEventRepository jdbcEventRepository;

    @PostMapping("/createEvent")
    public int createEvent(dbEvent event){
        return jdbcEventRepository.save(event);
    }

    @PutMapping("/updateEventCustomer{cID}/{eventID}")
    public int updateEventCustomer(@PathVariable int cID, @PathVariable int eventID){
        return jdbcEventRepository.updateEventCustomer(cID, eventID);
    }

    @PutMapping("/updateEventPackage{pID}/{eventID}")
    public int updateEventPackage(@PathVariable int pID, @PathVariable int eventID){
        return jdbcEventRepository.updateEventPackage(pID, eventID);
    }

    @GetMapping("/getAllEvents")
    public List<dbEvent> getAllEvents(){
        return jdbcEventRepository.getAllEvents();
    }

    @GetMapping("/eventTimeConflict/{start_time}/{end_time}")
    public boolean eventTimeConflict(@PathVariable String start_time, @PathVariable String end_time){
        return jdbcEventRepository.eventTimeConflict(start_time, end_time);
    }

    @GetMapping("/getEventForCustomer/{cID}")
    public List<dbEvent> getEventForCustomer(@PathVariable int cID){
        return jdbcEventRepository.getEventForCustomer(cID);        
    }
}

