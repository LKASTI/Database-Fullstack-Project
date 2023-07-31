package com.partytruckservice.controllers;

import com.partytruckservice.models.Customer;
import com.partytruckservice.repositories.JdbcCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/Customer")
public class CustomerController {
    @Autowired
    private JdbcCustomerRepository jdbcCustomerRepository;

    @PostMapping("/create")
    public int create(@RequestBody Map<String, String> body){
        int customerID = Integer.parseInt(body.get("customerID"));
        long phone = Long.parseLong(body.get("phone"));
        String address = body.get("address");
        String Fname = body.get("Fname");
        String Lname = body.get("Lname");
        String DOB = body.get("DOB");
        
        Customer customer = new Customer(customerID, phone, address, Fname, Lname, DOB);

        return jdbcCustomerRepository.save(customer);
    }

    @PutMapping("/updateName{customerId}/{Lname}/{Fname}")
    public int updateName(@PathVariable int customerId, @PathVariable String Lname, @PathVariable String Fname){
        return jdbcCustomerRepository.updateName(customerId, Lname, Fname);
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers(){
        return jdbcCustomerRepository.getAllCustomers();
    }
}