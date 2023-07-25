package com.partytruckservice.models;

import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@RequiredArgsConstructor
public class FullTimeEmployee extends Employee{
    @Getter
    @Setter
    private float salary;
    @Size(max=20)
    private String driversLicense;
    @Size(max=2)
    private String driversLicenseState;

}
