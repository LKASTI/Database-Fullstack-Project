package com.partytruckservice.repositories;

import com.partytruckservice.models.ContractEmployee;

public interface ContractEmployeeRepository {
    int save(ContractEmployee fullTimeEmployee);
    
    int update(ContractEmployee fullTimeEmployee);

    ContractEmployee getByID(float eID);

    int deleteByID(float eID);
}
