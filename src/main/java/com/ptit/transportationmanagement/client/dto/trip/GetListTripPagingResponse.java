package com.ptit.transportationmanagement.client.dto.trip;

import com.ptit.transportationmanagement.common.domain.BasePagingResponse;
import com.ptit.transportationmanagement.service.dto.TripDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class GetListTripPagingResponse  extends BasePagingResponse<TripDTO> {
}
