package com.partytruckservice.repositories.employee;

import java.util.List;

import com.partytruckservice.models.employee.FullTimeEmployee;

public interface FullTimeEmployeeRepository {
    public int save(FullTimeEmployee fullTimeEmployee);
    
    public int update(FullTimeEmployee fullTimeEmployee);

    public List<FullTimeEmployee> getByID(int eID);

    public List<FullTimeEmployee> getAllFullTimeEmployees();

    public int deleteByID(int eID);

}
