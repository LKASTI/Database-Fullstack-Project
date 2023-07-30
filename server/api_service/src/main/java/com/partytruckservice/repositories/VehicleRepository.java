package com.partytruckservice.repositories;

import com.partytruckservice.models.Vehicle;

import java.util.List;

public interface VehicleRepository {
    Integer count();

    int save(Vehicle vehicle);

    int updateMileage(String LicenseNum, int mileage);

    int deleteByLicenseNum(String LicenseNum);

    List<Vehicle> getAvailableVehicles();

}