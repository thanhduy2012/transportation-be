package com.ptit.transportationmanagement.common.utils;

import com.ptit.transportationmanagement.common.domain.OptimizedPage;
import org.springframework.data.domain.Page;

public class OptimizedPageUtils {
    public static OptimizedPage convert(Page page){
        OptimizedPage optimizedPage = new OptimizedPage();
        optimizedPage.setContent(page.getContent());
        optimizedPage.setCurrentPage(page.getPageable().getPageNumber()+1);
        optimizedPage.setPageSize(page.getSize());
        optimizedPage.setTotalPages(page.getTotalPages());
        optimizedPage.setTotalElements(page.getTotalElements());
        return optimizedPage;

    }
}
