package com.ptit.transportationmanagement.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@Accessors(chain = true)
public class DriverTripPK implements Serializable {

    @Column
    private Long driverId;
    @Column
    private Long tripId;
}
