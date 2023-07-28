package com.partytruckservice.models.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class ContractEmployee extends Employee {
    @Getter
    @Setter
    private float hourlyPayRate;

    public ContractEmployee(int eID, String FName, String LName, float hourlyPayRate) {
        this.employeeID = eID;
        this.FName = FName;
        this.LName = LName;
        this.hourlyPayRate = hourlyPayRate;
    }
}
