package com.partytruckservice.repositories;

import com.partytruckservice.models.Customer;

import java.util.*;

public interface CustomerRepository {
    Integer count();

    int save(Customer customer);

    int updateName(int customerId, String Lname, String Fname);

    int deleteByCustomerId(int customerId);

    List<Customer> getAllCustomers();

}