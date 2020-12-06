package com.ptit.transportationmanagement.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptimizedPage<T> {
    private List<T> content;
    int totalPages;
    int pageSize;
    int currentPage;
    long totalElements;
}
