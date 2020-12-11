package com.ptit.transportationmanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryCoachDTO  implements Serializable {

    private  CoachDTO coach;

    private Integer numberTrip;

    private Double salary;

    private Double distance;



}
