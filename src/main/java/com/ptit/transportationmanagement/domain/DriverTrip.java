package com.ptit.transportationmanagement.domain;

import lombok.Data;

import javax.persistence.*;

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

    private Integer status;
}
