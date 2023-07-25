package com.partytruckservice.repositories;

import com.partytruckservice.models.FullTimeEmployee;

public interface FullTimeEmployeeRepository {
    int save(FullTimeEmployee fullTimeEmployee);
    
    int update(FullTimeEmployee fullTimeEmployee);

    FullTimeEmployee getByID(float eID);

    int deleteByID(float eID);
}
