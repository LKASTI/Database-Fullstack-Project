package com.partytruckservice.repositories;

import java.util.List;

import com.partytruckservice.models.Vehicle;

public interface VehicleRepository {
    Integer count();

    int save(Vehicle vehicle);

    int updateMileage(String LicenseNum, int mileage);

    int deleteByLicenseNum(String LicenseNum);

    List<Vehicle> getAvailableVehicles();

    int assignVehicleToEvent(int eventID);

}