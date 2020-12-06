package com.ptit.transportationmanagement.client.dto.driver;

import com.ptit.transportationmanagement.service.dto.DriverDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDriverRequest {
    private DriverDTO driver;
}
