package com.partytruckservice.repositories.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.partytruckservice.models.employee.FullTimeEmployee;

@Repository
public class JdbcFullTimeEmployeeRepository implements FullTimeEmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(FullTimeEmployee fullTimeEmployee) {
        jdbcTemplate.update("INSERT INTO employee (employeeID, FName, LName) values(?, ?, ?)",
                fullTimeEmployee.getEmployeeID(), fullTimeEmployee.getFName(), fullTimeEmployee.getLName());
        return jdbcTemplate.update(
                "INSERT INTO fulltime_employee (eID, salary, driversLicense, DL_state) values(?, ?, ?, ?)",
                fullTimeEmployee.getEmployeeID(), fullTimeEmployee.getSalary(), fullTimeEmployee.getDriversLicense(),
                fullTimeEmployee.getDriversLicenseState());
    }

    @Override
    public int update(FullTimeEmployee fullTimeEmployee) {
        return jdbcTemplate.update(
                "UPDATE employee SET FName=?, Lname=? WHERE employeeID = ?; UPDATE fulltime_employee SET salary=?, driversLicense=?, DL_state=? WHERE eID = ?",
                fullTimeEmployee.getFName(), fullTimeEmployee.getLName(), fullTimeEmployee.getEmployeeID(),
                fullTimeEmployee.getSalary(), fullTimeEmployee.getDriversLicense(),
                fullTimeEmployee.getDriversLicenseState(), fullTimeEmployee.getEmployeeID());
    }

    @Override
    public List<FullTimeEmployee> getByID(int eID) {
        return jdbcTemplate.query(
                "SELECT eID, salary, driversLicense, DL_state, Fname, Lname FROM fulltime_employee, employee WHERE eID = ? AND employeeID=eID",
                BeanPropertyRowMapper.newInstance(FullTimeEmployee.class), eID

        );
    }

    @Override
    public List<FullTimeEmployee> getAllFullTimeEmployees() {
        return jdbcTemplate.query(
                "SELECT eID, salary, driversLicense, DL_state, Fname, Lname FROM fulltime_employee, EMPLOYEE where eID=employeeID;",
                (rs, rowNum) -> new FullTimeEmployee(
                        rs.getInt("eID"),
                        rs.getString("FName"),
                        rs.getString("LName"),
                        rs.getFloat("salary"),
                        rs.getString("driversLicense"),
                        rs.getString("DL_state")));
    }

    @Override
    public int deleteByID(int eID) {
        return jdbcTemplate.update(
                "DELETE employee WHERE employeeID = ?", eID

        );
    }
}
