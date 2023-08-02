package com.partytruckservice.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.partytruckservice.models.Vehicle;
import com.partytruckservice.repositories.JdbcVehicleRepository;

@RestController
@CrossOrigin
@RequestMapping("/Vehicle")
public class VehicleController {
    @Autowired
    private JdbcVehicleRepository jdbcVehicleRepository;

    @PostMapping("create")
    public int create(@RequestBody Map<String, String> body){
        String LicenseNum = body.get("LicenseNum");
        String state = body.get("state");
        int mileage = Integer.parseInt(body.get("mileage"));
        
        Vehicle vehicle = new Vehicle(LicenseNum, state, mileage);

        return jdbcVehicleRepository.save(vehicle);
    }

    @PutMapping("/updateMileage{LicenseNum}/{mileage}")
    public int updateMileage(@PathVariable String LicenseNum, @PathVariable int mileage){
        return jdbcVehicleRepository.updateMileage(LicenseNum, mileage);
    }

    @GetMapping("/getAvailableVehicles")
    public List<Vehicle> getAvailableVehicles(){
        return jdbcVehicleRepository.getAvailableVehicles();
    }

    @PostMapping("/assignVehicleToEvent{eventID}")
    public int assignVehicleToEvent(@PathVariable int eventID){
        return jdbcVehicleRepository.assignVehicleToEvent(eventID);
    }

}