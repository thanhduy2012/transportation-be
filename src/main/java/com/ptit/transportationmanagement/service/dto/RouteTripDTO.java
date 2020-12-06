package com.ptit.transportationmanagement.service.dto;

import com.ptit.transportationmanagement.domain.RouteTripPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteTripDTO implements Serializable {

    private RouteTripPK id;

    private Long routeId;

    private Long tripId;

    private Integer status;
}
