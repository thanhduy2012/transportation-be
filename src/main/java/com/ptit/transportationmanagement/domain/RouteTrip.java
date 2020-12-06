package com.ptit.transportationmanagement.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "route_trip")
@Data
public class RouteTrip {
    @EmbeddedId
    private RouteTripPK id;

    @ManyToOne
    @JoinColumn(name = "routeId", referencedColumnName = "id", insertable = false, updatable = false)
    private Route route;

    @ManyToOne
    @JoinColumn(name = "tripId", referencedColumnName = "id", insertable = false, updatable = false)
    private Trip trip;

    private Integer status;
}
