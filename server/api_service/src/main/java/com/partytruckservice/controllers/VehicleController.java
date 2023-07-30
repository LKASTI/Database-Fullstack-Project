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

}