package com.ptit.transportationmanagement.client.dto.coach;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetSalaryRequest {
    private Long coachId;
    private LocalDate fromDate;
    private LocalDate toDate;

}
