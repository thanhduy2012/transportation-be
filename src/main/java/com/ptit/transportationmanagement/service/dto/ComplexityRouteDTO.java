package com.ptit.transportationmanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplexityRouteDTO implements Serializable {
//    private ComplexityRoutePK id;

    private Long complexityId;

    private Long routeId;

    private Integer status;

}
