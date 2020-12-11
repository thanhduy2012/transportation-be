package com.ptit.transportationmanagement.client.dto.driver;

import com.ptit.transportationmanagement.service.dto.SalaryDriverDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetSalaryOfDriverWithMonthResponse {

    private SalaryDriverDTO salaryDriverDTO;
}
