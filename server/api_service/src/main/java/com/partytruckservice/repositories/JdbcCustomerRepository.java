package com.partytruckservice.repositories;

import com.partytruckservice.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.*;

@Repository
public class JdbcCustomerRepository implements CustomerRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM customer", Integer.class);
    }

    @Override
    public int save(Customer customer){
        return jdbcTemplate.update(
            "INSERT INTO customer (customerId, phone, address, Fname, Lname, DOB) VALUES(?, ?, ?, ?, ?, ?)",
            customer.getCustomerID(), customer.getPhone(), customer.getAddress(), customer.getFname(), customer.getLname(), customer.getDOB()
        );
    }
    
    @Override
    public int updateName(int customerId, String Fname, String Lname) {
        return jdbcTemplate.update(
            "UPDATE customer SET Fname=?, Lname=? where customerId=?",
            Fname, Lname, customerId
            );
    }

    @Override
    public int deleteByCustomerId(int customerId) {
        return jdbcTemplate.update(
            "DELETE customer WHERE customerId = ?",
            customerId
        );
    }

    @Override
    public List<Customer> getAllCustomers(){
        return jdbcTemplate.query(
            "SELECT * FROM customer",
            (rs, rowNum) -> 
                new Customer(
                    rs.getInt("customerID"),
                    rs.getLong("phone"),
                    rs.getString("address"),
                    rs.getString("Fname"),
                    rs.getString("Lname"),
                    rs.getString("DOB")
                )
        );
    }

}