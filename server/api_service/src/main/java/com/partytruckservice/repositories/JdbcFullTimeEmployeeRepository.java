package com.partytruckservice.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.partytruckservice.models.FullTimeEmployee;

public class JdbcFullTimeEmployeeRepository implements FullTimeEmployeeRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(FullTimeEmployee fullTimeEmployee){
        return 0;
    }
    
    @Override
    public int update(FullTimeEmployee fullTimeEmployee){
        return jdbcTemplate.update("UPDATE employee SET FName=?, Lname=? WHERE employeeID = ?; UPDATE fulltime_employee SET salary=?, driversLicense=?, DL_state=? WHERE eID = ?",
        fullTimeEmployee.getFName(), fullTimeEmployee.getLName(), fullTimeEmployee.getEmployeeID(), fullTimeEmployee.getSalary(), fullTimeEmployee.getDriversLicense(), fullTimeEmployee.getDriversLicenseState(), fullTimeEmployee.getEmployeeID());
    }

    @Override
    public List<FullTimeEmployee> getByID(float eID){
        return jdbcTemplate.query(
            "SELECT * FROM fulltime_employee WHERE eID = ?", 
            BeanPropertyRowMapper.newInstance(FullTimeEmployee.class), eID
            
        );
    }

    @Override
    public int deleteByID(float eID){
        return jdbcTemplate.update(
            "DELETE employee WHERE employeeID = ?", eID
            
        );
    }
}
