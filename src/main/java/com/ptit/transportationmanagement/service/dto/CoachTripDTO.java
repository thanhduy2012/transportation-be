package com.ptit.transportationmanagement.service.dto;

import com.ptit.transportationmanagement.domain.CoachTripPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoachTripDTO implements Serializable {

    private CoachTripPK id;

    private Long coachId;

    private Long tripId;

    private Integer status;
}
