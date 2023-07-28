package com.partytruckservice.models.employee;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FullTimeEmployee extends Employee {
    private float salary;
    @Size(max = 20)
    private String driversLicense;
    @Size(max = 2)
    private String driversLicenseState;

    public FullTimeEmployee(){}

    public FullTimeEmployee(int eID, String FName, String LName, float salary, String driversLicense, String DLState) {
        this.employeeID = eID;
        this.FName = FName;
        this.LName = LName;
        this.salary = salary;
        this.driversLicense = driversLicense;
        this.driversLicenseState = DLState;
    }

}
