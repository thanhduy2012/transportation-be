package com.ptit.transportationmanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {

    private Long id;

    @NotEmpty
    private String name;
    @NotEmpty
    private String identityCard;
    @NotEmpty
    private String licenseDriver;
    @NotEmpty
    private String typeLicenseDriver;
    @NotEmpty
    private String address;
    @NotEmpty
    private LocalDate dateOfBirth;

    private LocalDate fromDOB;

    private LocalDate toDOB;
    @NotEmpty
    private Integer seniority;

    private String createdBy;

    private LocalDate createdDate;

    private String updatedBy;

    private LocalDate updatedDate;
}
