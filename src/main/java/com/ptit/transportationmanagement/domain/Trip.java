package com.ptit.transportationmanagement.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "trip")
@Data
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private Integer numberGuest;

    private Double price;

    private Integer status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    private String createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate updatedDate;

    private String updatedBy;

//    @OneToMany(mappedBy = "trip")
//    private List<CoachTrip> coachTrips;
//
//    @OneToMany(mappedBy = "trip")
//    private List<DriverTrip> driverTrips;
//
//    @OneToMany(mappedBy = "trip")
//    private List<RouteTrip> routeTrips;
}
