package com.partytruckservice.repositories;

import com.partytruckservice.models.Vehicle;

import java.util.List;

public interface VehicleRepository {
    int count();

    int save(Vehicle vehicle);

    int updateMileage(int eventID, int mileage);

    int deleteByEventID(int eventID);

    List<Vehicle> getAvailableVehicles();

}