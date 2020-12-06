package com.ptit.transportationmanagement.client.dto.route;

import com.ptit.transportationmanagement.service.dto.RouteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRouteRequest {
    private RouteDTO route;
}
