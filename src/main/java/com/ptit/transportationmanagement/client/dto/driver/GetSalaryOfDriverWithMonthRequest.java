package com.ptit.transportationmanagement.client.dto.driver;

import lombok.Data;

@Data
public class GetSalaryOfDriverWithMonthRequest {
    private Long driverId;
    private Integer month;
}
