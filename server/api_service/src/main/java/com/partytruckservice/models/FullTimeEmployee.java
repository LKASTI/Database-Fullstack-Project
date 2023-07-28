package com.partytruckservice.models;

import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.Data;

@RequiredArgsConstructor
@Data
public class FullTimeEmployee extends Employee{
    private float salary;
    @Size(max=20)
    private String driversLicense;
    @Size(max=2)
    private String driversLicenseState;

}
