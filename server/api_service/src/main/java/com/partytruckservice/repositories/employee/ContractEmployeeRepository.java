package com.partytruckservice.repositories.employee;

import java.util.List;

import com.partytruckservice.models.employee.ContractEmployee;

public interface ContractEmployeeRepository {
    public int save(ContractEmployee contractEmployee);

    public int update(ContractEmployee contractEmployee);

    public List<ContractEmployee> getByID(int eID);

    public int deleteByID(int eID);
}
