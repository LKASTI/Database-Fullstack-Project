package com.partytruckservice.controllers;

import com.partytruckservice.models.Vehicle;
import com.partytruckservice.repositories.JdbcVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/Vehicle")
public class VehicleController {
    @Autowired
    private JdbcVehicleRepository jdbcVehicleRepository;

    @PostMapping("create")
    public int create(@RequestBody Map<String, String> body){
        int LicenseNum = Integer.parseInt(body.get("LicenseNum"));
        String state = body.get("state");
        int eventID = Integer.parseInt(body.get("eventID"));
        int mileage = Integer.parseInt(body.get("mileage"));
        
        Vehicle vehicle = new Vehicle(LicenseNum, state, eventID, mileage);

        return jdbcVehicleRepository.save(vehicle);
    }

    @PutMapping("/updateMileage{eventID}/{mileage}")
    public int updateMileage(@PathVariable int eventID, @PathVariable int mileage){
        return jdbcVehicleRepository.updateMileage(eventID, mileage);
    }

    @GetMapping("/getAvailableVehicles")
    public List<Vehicle> getAvailableVehicles(){
        return jdbcVehicleRepository.getAvailableVehicles();
    }

}