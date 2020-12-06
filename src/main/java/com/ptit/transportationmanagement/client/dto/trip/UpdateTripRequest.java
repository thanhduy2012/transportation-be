package com.ptit.transportationmanagement.client.dto.trip;

import com.ptit.transportationmanagement.service.dto.TripDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTripRequest {
    private TripDTO trip;
}
