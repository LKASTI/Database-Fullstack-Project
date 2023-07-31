package com.partytruckservice.models;

import org.springframework.data.annotation.*;
import java.util.*;

public class Package_ {
    private int packageID;
    private double discount;
    private String name;
    // not sure if i need a price, not using it for now, can use it later if needed
    private int price;

    // constructor
    public Package_(String name, int packageID, double discount) {
        this.name = name;
        this.packageID = packageID;
        this.discount = discount;
    }

    public String toString() {// this is in order of tuple on SQL table PACKAGE
        return "Package [" + packageID + ", " + name + "," + discount + "]";
    }

    // setters
    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    // getters
    public int getPackageID() {
        return packageID;
    }

    public double getDiscount() {
        return discount;
    }

    public String getName() {
        return name;
    }
}
