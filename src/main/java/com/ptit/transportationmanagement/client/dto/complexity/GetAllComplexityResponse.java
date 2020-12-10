package com.ptit.transportationmanagement.client.dto.complexity;

import com.ptit.transportationmanagement.service.dto.ComplexityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllComplexityResponse {
    private List<ComplexityDTO> complexities;
}
