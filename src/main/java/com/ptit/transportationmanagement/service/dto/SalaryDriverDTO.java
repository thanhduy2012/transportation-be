package com.ptit.transportationmanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryDriverDTO implements Serializable {

    private DriverDTO driver;

    private Double salary;

    private Integer month;

    private Integer numberOfMainDriver;

    private Integer numberOfSupportDriver;
}
