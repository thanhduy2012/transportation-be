package com.ptit.transportationmanagement.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "route")
@Data
@Accessors(chain = true)
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstLocation;

    private String lastLocation;

    private Long length;

    private String createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    protected LocalDate createdDate;

    private String updatedBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate updatedDate;

//    @OneToMany(mappedBy = "route")
//    private List<RouteTrip> routeTrips;
    @ManyToOne
    @JoinColumn(name = "complexityId", referencedColumnName = "id")
    private Complexity complexity;


}
