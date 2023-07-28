package com.partytruckservice.models;

import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@RequiredArgsConstructor
public class ContractEmployee extends Employee {
    @Getter
    @Setter
    private float hourlyPayRate;
}
