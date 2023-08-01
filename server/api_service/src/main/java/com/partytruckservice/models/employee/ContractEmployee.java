package com.partytruckservice.models.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ContractEmployee extends Employee {

    private float hourlyPayRate;

    public ContractEmployee() {
        super();
    }

    public ContractEmployee(int eID, String FName, String LName, float hourlyPayRate) {
        super(eID, FName, LName);
        this.hourlyPayRate = hourlyPayRate;
    }
}
