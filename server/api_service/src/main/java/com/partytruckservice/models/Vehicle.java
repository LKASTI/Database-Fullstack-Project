package com.partytruckservice.models;

import org.springframework.data.annotation.*;

public class Vehicle {
    @Id
    private int LicenseNum;
    private String state;
    private int mileage;

    public Vehicle(int LicenseNum, String state, int mileage) {
        this.LicenseNum = LicenseNum;
        this.state = state;
        this.mileage = mileage;
    }

    public String toString() {
        return "Vehicle [" + LicenseNum + ", " + state + ", " + ", " + mileage + "]";
    }

    public void setLicenseNum(int LicenseNum) {
        this.LicenseNum = LicenseNum;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getLicenseNum() {
        return LicenseNum;
    }

    public String getState() {
        return state;
    }

    public int getMileage() {
        return mileage;
    }

}