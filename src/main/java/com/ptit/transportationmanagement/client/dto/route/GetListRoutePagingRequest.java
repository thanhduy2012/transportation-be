package com.ptit.transportationmanagement.client.dto.route;

import com.ptit.transportationmanagement.common.domain.BasePagingRequest;
import com.ptit.transportationmanagement.service.dto.RouteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListRoutePagingRequest extends BasePagingRequest {

    private RouteDTO route;

}
