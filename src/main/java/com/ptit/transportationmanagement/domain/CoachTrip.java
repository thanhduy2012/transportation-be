package com.ptit.transportationmanagement.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "coach_trip")
@Data
public class CoachTrip {

    @EmbeddedId
    private CoachTripPK id;

    @ManyToOne
    @JoinColumn(name = "coachId", referencedColumnName = "id", insertable = false, updatable = false)
    private Coach coach;

    @ManyToOne
    @JoinColumn(name = "tripId", referencedColumnName = "id", insertable = false, updatable = false)
    private Trip trip;

    private Integer status;
}
