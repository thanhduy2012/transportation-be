package com.ptit.transportationmanagement.client.dto.complexity;

import com.ptit.transportationmanagement.service.dto.ComplexityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateComplexityResponse {
    private ComplexityDTO complexity;
}
