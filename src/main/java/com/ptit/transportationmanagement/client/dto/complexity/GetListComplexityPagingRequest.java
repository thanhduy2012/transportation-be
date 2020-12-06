package com.ptit.transportationmanagement.client.dto.complexity;

import com.ptit.transportationmanagement.common.domain.BasePagingRequest;
import com.ptit.transportationmanagement.service.dto.ComplexityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetListComplexityPagingRequest  extends BasePagingRequest {
    private ComplexityDTO complexity;
}
