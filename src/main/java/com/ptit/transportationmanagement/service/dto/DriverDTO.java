package com.ptit.transportationmanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {

    private Long id;

    private String name;

    private String identityCard;

    private String licenseDriver;

    private String typeLicenseDriver;

    private String address;

    private LocalDate dateOfBirth;

    private LocalDate fromDOB;

    private LocalDate toDOB;

    private Integer seniority;

    private String createdBy;

    private LocalDate createdDate;

    private String updatedBy;

    private LocalDate updatedDate;
}
