package com.ptit.transportationmanagement.common.domain;

import lombok.Data;

@Data
public class BasePagingResponse<T> {
    private OptimizedPage<T> page;
}
