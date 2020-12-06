package com.ptit.transportationmanagement.client.dto.route;

import com.ptit.transportationmanagement.common.domain.BasePagingResponse;
import com.ptit.transportationmanagement.service.dto.RouteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class GetListRoutePagingResponse extends BasePagingResponse<RouteDTO> {
}
