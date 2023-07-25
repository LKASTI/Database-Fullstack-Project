package com.partytruckservice.models;
import lombok.Setter;
import lombok.Getter;
public abstract class Employee {
    @Getter
    @Setter
    protected int employeeID;
    protected String fName;
    protected String lName;
    protected int eventID;

}
