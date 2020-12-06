package com.ptit.transportationmanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplexityDTO implements Serializable {

    private Long id;

    @NotNull
    private String code;

    @NotNull
    private String description;

    @NotNull
    private Double coefficientSalary;

    @NotNull
    private Integer status;
}
