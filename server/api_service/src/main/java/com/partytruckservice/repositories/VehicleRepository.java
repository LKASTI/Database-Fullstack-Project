package com.partytruckservice.repositories;

import com.partytruckservice.models.Vehicle;

import java.util.List;

public interface VehicleRepository {
    Integer count();

    int save(Vehicle vehicle);

    int updateMileage(int LicenseNum, int mileage);

    int deleteByLicenseNum(int LicenseNum);

    List<Vehicle> getAvailableVehicles();

}