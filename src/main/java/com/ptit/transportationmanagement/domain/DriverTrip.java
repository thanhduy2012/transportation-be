package com.ptit.transportationmanagement.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "driver_trip")
@Data
public class DriverTrip {

    @EmbeddedId
    private DriverTripPK id;

    @ManyToOne
    @JoinColumn(name = "driverId", referencedColumnName = "id", insertable = false, updatable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "tripId", referencedColumnName = "id", insertable = false, updatable = false)
    private Trip trip;

    private Integer position;

    private Double salary;

    private Integer status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
}
