package com.ptit.transportationmanagement.client.dto.driver;

import com.ptit.transportationmanagement.common.domain.BasePagingRequest;
import com.ptit.transportationmanagement.service.dto.DriverDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListDriverPagingRequest extends BasePagingRequest {
    private DriverDTO driver;
}
