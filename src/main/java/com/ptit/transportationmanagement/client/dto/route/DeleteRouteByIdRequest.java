package com.ptit.transportationmanagement.client.dto.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteRouteByIdRequest {
    private Long id;
}
