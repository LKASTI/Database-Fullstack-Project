package com.partytruckservice.repositories;

import java.util.List;

import com.partytruckservice.models.FullTimeEmployee;

public interface FullTimeEmployeeRepository {
    public int save(FullTimeEmployee fullTimeEmployee);
    
    public int update(FullTimeEmployee fullTimeEmployee);

    public List<FullTimeEmployee> getByID(float eID);

    public int deleteByID(float eID);
}
