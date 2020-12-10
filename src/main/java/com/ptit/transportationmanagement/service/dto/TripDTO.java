package com.ptit.transportationmanagement.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripDTO implements Serializable {

    private Long id;

    @NotNull
    private String code;

    @NotNull
    private Integer numberGuest;

    @NotNull
    private Double price;

    private Integer status;

    private DriverDTO supDriver;

    private DriverDTO mainDriver;

    private RouteDTO route;

    private CoachDTO coach;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    private String createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate updatedDate;

    private String updatedBy;

}
