package com.ptit.transportationmanagement.client.dto.coach;

import com.ptit.transportationmanagement.common.domain.BasePagingResponse;
import com.ptit.transportationmanagement.service.dto.CoachDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class GetListCoachPagingResponse extends BasePagingResponse<CoachDTO> {
}
