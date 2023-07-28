package com.partytruckservice.controllers;

import com.partytruckservice.models.*;
import com.partytruckservice.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Map;

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
}

