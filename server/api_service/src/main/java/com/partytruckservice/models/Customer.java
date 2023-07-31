package com.partytruckservice.models;

import org.springframework.data.annotation.*;

public class Customer {
    @Id
    private int customerID;
    private long phone;
    private String address;
    private String Fname;
    private String Lname;
    private String DOB;

    public Customer(long phone, String address, String Fname, String Lname, String DOB) {
        this.phone = phone;
        this.address = address;
        this.Fname = Fname;
        this.Lname = Lname;
        this.DOB = DOB;
    }

    public Customer(int customerID, long phone, String address, String Fname, String Lname, String DOB) {
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

    public void setPhone(long phone) {
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

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public int getCustomerID() {
        return customerID;
    }

    public long getPhone() {
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

    public String getDOB() {
        return DOB;
    }

}