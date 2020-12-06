package com.ptit.transportationmanagement.client.dto.driver;

import com.ptit.transportationmanagement.common.domain.BasePagingResponse;
import com.ptit.transportationmanagement.service.dto.DriverDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class GetListDriverPagingResponse extends BasePagingResponse<DriverDTO> {
}
