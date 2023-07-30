package com.partytruckservice.controllers.employee;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.partytruckservice.models.employee.ContractEmployee;
import com.partytruckservice.repositories.employee.JdbcContractEmployeeRepository;

@RestController
@CrossOrigin
@RequestMapping("/contractEmployee")
public class ContractEmployeeController {

    @Autowired
    private JdbcContractEmployeeRepository jdbcContractEmployeeRepository;

    @PostMapping("/create")
    public int create(@RequestBody Map<String, String> body) {
        int eID = Integer.parseInt(body.get("employeeID"));
        String FName = body.get("Fname");
        String LName = body.get("Lname");
        float hourlyPayRate = Float.parseFloat(body.get("hourlyPayRate"));
        return jdbcContractEmployeeRepository.save(new ContractEmployee(eID, FName, LName, hourlyPayRate));
    }

    @GetMapping("/getByID/{eID}")
    public List<ContractEmployee> getByID(@PathVariable int eID) {
        return jdbcContractEmployeeRepository.getByID(eID);
    }

    @DeleteMapping("/deleteByID/{eID}")
    public int deleteByID(@PathVariable int eID) {
        return jdbcContractEmployeeRepository.deleteByID(eID);
    }
}
