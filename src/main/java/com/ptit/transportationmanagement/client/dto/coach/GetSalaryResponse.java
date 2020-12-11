package com.ptit.transportationmanagement.client.dto.coach;

import com.ptit.transportationmanagement.service.dto.SalaryCoachDTO;
import lombok.Data;

@Data
public class GetSalaryResponse {
    private SalaryCoachDTO salaryCoachDTO;
}
