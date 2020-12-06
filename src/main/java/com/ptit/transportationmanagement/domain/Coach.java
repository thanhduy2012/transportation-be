package com.ptit.transportationmanagement.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "coach")
@Data
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Size(max = 20)
    @NotNull
    private String licensePlate;

    @NotNull
    private String color;

    @NotNull
    private String manufacturer;

    @NotNull
    private String model;

    @NotNull
    private Integer seatNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate lastDateMaintenance;

    private String createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    private String updatedBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate updatedDate;

//
//    @OneToMany(mappedBy = "coach")
//    private List<CoachTrip> coachTrips;
}


