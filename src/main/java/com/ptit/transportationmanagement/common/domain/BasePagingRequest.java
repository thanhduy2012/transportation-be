package com.ptit.transportationmanagement.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasePagingRequest {
    private int pageNumber;
    private int pageSize;
}
