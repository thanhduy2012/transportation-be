package com.ptit.transportationmanagement.service.dto;

import com.ptit.transportationmanagement.domain.DriverTripPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverTripDTO implements Serializable {

    private DriverTripPK id;

    private Long driverId;

    private Long tripId;

    private Integer status;
}
