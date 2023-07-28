package com.partytruckservice.repositories.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.partytruckservice.models.employee.ContractEmployee;

@Repository
public class JdbcContractEmployeeRepository implements ContractEmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(ContractEmployee contractEmployee) {
        return jdbcTemplate.update(
                "INSERT INTO employee (employeeID, FName, LName) values(?, ?, ?); INSERT INTO contract_employee (eID, hourlyPayRate) values(?, ?)",
                contractEmployee.getEmployeeID(), contractEmployee.getFName(), contractEmployee.getLName(),
                contractEmployee.getHourlyPayRate());
    }

    @Override
    public int update(ContractEmployee contractEmployee) {
        return jdbcTemplate.update(
                "UPDATE employee SET FName=?, Lname=? WHERE employeeID = ?; UPDATE contract_employee SET hourlyPayRate=? WHERE eID = ?",
                contractEmployee.getFName(), contractEmployee.getLName(), contractEmployee.getEmployeeID(),
                contractEmployee.getHourlyPayRate(), contractEmployee.getEmployeeID());
    }

    @Override
    public List<ContractEmployee> getByID(int eID) {
        return jdbcTemplate.query(
                "SELECT * FROM contract_employee WHERE eID = ?",
                BeanPropertyRowMapper.newInstance(ContractEmployee.class), eID

        );
    }

    @Override
    public int deleteByID(int eID) {
        return jdbcTemplate.update(
                "DELETE employee WHERE employeeID = ?", eID

        );
    }
}