package com.ptit.transportationmanagement.client.dto.driver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteDriverByIdRequest {
    private Long id;
}
