package com.ptit.transportationmanagement.client.dto.coach;

import com.ptit.transportationmanagement.common.domain.BasePagingRequest;
import com.ptit.transportationmanagement.service.dto.CoachDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListCoachPagingRequest extends BasePagingRequest {
    private CoachDTO coach;
}
