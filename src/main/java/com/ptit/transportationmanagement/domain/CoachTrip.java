package com.ptit.transportationmanagement.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

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

    private Double salary;

    private Double distance;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
}
