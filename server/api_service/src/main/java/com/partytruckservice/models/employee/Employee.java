package com.partytruckservice.models.employee;

import io.micrometer.common.lang.NonNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public abstract class Employee {
    @NonNull protected int employeeID;
    protected String FName;
    protected String LName;

}
