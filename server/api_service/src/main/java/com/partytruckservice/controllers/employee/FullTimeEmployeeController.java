package com.partytruckservice.controllers.employee;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.partytruckservice.models.employee.FullTimeEmployee;
import com.partytruckservice.repositories.employee.JdbcFullTimeEmployeeRepository;

@RestController
@CrossOrigin
@RequestMapping("/fullTimeEmployee")
public class FullTimeEmployeeController {
    @Autowired
    private JdbcFullTimeEmployeeRepository jdbcFullTimeEmployeeRepository;

    @PostMapping("/create")
    public int create(@RequestBody Map<String, String> body) {
        int eID = Integer.parseInt(body.get("employeeID"));
        String FName = body.get("FName");
        String LName = body.get("LName");
        float salary = Float.parseFloat(body.get("salary"));
        String driversLicense = body.get("driversLicense");
        String DLState = body.get("DL_state");
        return jdbcFullTimeEmployeeRepository.save(new FullTimeEmployee(eID, FName, LName, salary, driversLicense, DLState));
    }

    @GetMapping("/getByID/{eID}")
    public List<FullTimeEmployee> getByID(@PathVariable int eID) {
        return jdbcFullTimeEmployeeRepository.getByID(eID);
    }

    @GetMapping("/getAllFullTimeEmployees")
    public List<FullTimeEmployee> getAllFullTimeEmployees() {
        return jdbcFullTimeEmployeeRepository.getAllFullTimeEmployees();
    }

    @DeleteMapping("/deleteByID/{eID}")
    public int deleteByID(@PathVariable int eID) {
        return jdbcFullTimeEmployeeRepository.deleteByID(eID);
    }

}
