package com.partytruckservice.repositories;

import java.util.List;

import com.partytruckservice.models.ContractEmployee;

public interface ContractEmployeeRepository {
    public int save(ContractEmployee contractEmployee);
    
    public int update(ContractEmployee contractEmployee);

    public List<ContractEmployee> getByID(float eID);

    public int deleteByID(float eID);
}
