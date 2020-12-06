package com.ptit.transportationmanagement.client.dto.trip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteTripByIdRequest {
    private Long id;
}
