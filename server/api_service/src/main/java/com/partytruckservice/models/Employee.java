package com.partytruckservice.models;

import lombok.Data;

@Data
public abstract class Employee {
    protected int employeeID;
    protected String FName;
    protected String LName;

}
