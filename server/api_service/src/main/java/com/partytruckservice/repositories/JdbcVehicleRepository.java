package com.partytruckservice.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.partytruckservice.models.Vehicle;

@Repository
public class JdbcVehicleRepository implements VehicleRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Vehicle", Integer.class);
    }

    @Override
    public int assignVehicleToEvent(int eventID){
        return jdbcTemplate.update(
            "INSERT INTO delivers (eventID, LicenseNum) VALUES (?, (SELECT LicenseNum FROM Vehicle WHERE Vehicle.LicenseNum NOT IN (SELECT LicenseNum FROM (SELECT * FROM delivers) as x) LIMIT 1))",
            eventID
        );
    }

    @Override
    public int save(Vehicle vehicle){
        return jdbcTemplate.update(
            "INSERT INTO vehicle (LicenseNum, state, mileage) VALUES(?, ?, ?)",
            vehicle.getLicenseNum(), vehicle.getState(), vehicle.getMileage()
        );
    }
    
    @Override
    public int updateMileage(String LicenseNum, int mileage) {
        return jdbcTemplate.update(
            "UPDATE vehicle SET mileage=? where LicenseNum=?",
            mileage, LicenseNum
        );
    }

    @Override
    public int deleteByLicenseNum(String LicenseNum){
        return jdbcTemplate.update(
            "DELETE vehicle WHERE LicenseNum=?",
            LicenseNum
        );
    }

    @Override
    public List<Vehicle> getAvailableVehicles(){
        return jdbcTemplate.query(
            "SELECT * FROM vehicle",
            (rs, rowNum) -> 
                new Vehicle(
                    rs.getString("LicenseNum"),
                    rs.getString("state"),
                    rs.getInt("mileage")
                )
        );
    }

}