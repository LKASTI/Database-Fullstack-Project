package com.partytruckservice.repositories;

import com.partytruckservice.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class JdbcVehicleRepository implements VehicleRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Vehicle", Integer.class);
    }

    @Override
    public int save(Vehicle vehicle){
        return jdbcTemplate.update(
            "INSERT INTO vehicle (LicenseNum, state, eventID, mileage) VALUES(?, ?, ?, ?)",
            vehicle.getLicenseNum(), vehicle.getState(), vehicle.getEventID(), vehicle.getMileage()
        );
    }
    
    @Override
    public int updateMileage(int eventID, int mileage) {
        return jdbcTemplate.update(
            "UPDATE vehicle SET mileage=? where eventID=?",
            mileage, eventID
        );
    }

    @Override
    public int deleteByEventID(int eventID){
        return jdbcTemplate.update(
            "DELETE vehicle WHERE eventID=?",
            eventID
        );
    }

    @Override
    public List<Vehicle> getAvailableVehicles(){
        return jdbcTemplate.query(
            "SELECT * FROM vehicle",
            (rs, rowNum) -> 
                new Vehicle(
                    rs.getInt("LicenseNum"),
                    rs.getString("state"),
                    rs.getInt("eventID"),
                    rs.getInt("mileage")
                )
        );
    }

}