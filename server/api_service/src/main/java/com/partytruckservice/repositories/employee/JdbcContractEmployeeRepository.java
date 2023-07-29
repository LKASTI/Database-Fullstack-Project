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
        jdbcTemplate.update("INSERT INTO employee (employeeID, Fname, Lname) values(?, ?, ?)",
                contractEmployee.getEmployeeID(), contractEmployee.getFName(), contractEmployee.getLName());
        return jdbcTemplate.update(
                "INSERT INTO contract_employee (eID, hourlyPayRate) values(?, ?)",
                contractEmployee.getEmployeeID(),
                contractEmployee.getHourlyPayRate());
    }

    @Override
    public int update(ContractEmployee contractEmployee) {
        jdbcTemplate.update("UPDATE employee SET Fname=?, Lname=? WHERE employeeID = ?", contractEmployee.getFName(),
                contractEmployee.getLName());
        return jdbcTemplate.update(
                "UPDATE contract_employee SET hourlyPayRate=? WHERE eID = ?",
                contractEmployee.getHourlyPayRate(), contractEmployee.getEmployeeID());
    }

    @Override
    public List<ContractEmployee> getByID(int eID) {
        return jdbcTemplate.query(
                "SELECT eID, hourlyPayRate, Fname, Lname FROM contract_employee, employee WHERE eID = ? AND eID=employeeID",
                (rs, rowNum) -> new ContractEmployee(
                        rs.getInt("eID"),
                        rs.getString("Fname"),
                        rs.getString("Lname"),
                        rs.getFloat("hourlyPayRate")), eID);
    }

    @Override
    public int deleteByID(int eID) {
        jdbcTemplate.update("DELETE FROM contract_employee where eID = ?", eID);
        return jdbcTemplate.update(
                "DELETE FROM employee WHERE employeeID = ?", eID

        );
    }
}
