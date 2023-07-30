package com.partytruckservice.models;

import org.springframework.data.annotation.*;
import java.util.*;

public class Customer {
    @Id
    private int customerID;
    private int phone;
    private String address;
    private String Fname;
    private String Lname;
    private int DOB;

    public Customer(int phone, String address, String Fname, String Lname, int DOB) {
        this.phone = phone;
        this.address = address;
        this.Fname = Fname;
        this.Lname = Lname;
        this.DOB = DOB;
    }

    public Customer(int customerID, int phone, String address, String Fname, String Lname, int DOB) {
        this.customerID = customerID;
        this.phone = phone;
        this.address = address;
        this.Fname = Fname;
        this.Lname = Lname;
        this.DOB = DOB;
    }

    public String toString() {
        return "Customer [" + customerID + ", " + phone + ", " + address + ", " + Fname + ", " + Lname + ", " + DOB + "]";
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public void setDOB(int DOB) {
        this.DOB = DOB;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public int getDOB() {
        return DOB;
    }
}
