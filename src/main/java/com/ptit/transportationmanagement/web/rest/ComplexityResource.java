package com.ptit.transportationmanagement.web.rest;

import com.ptit.transportationmanagement.client.dto.complexity.GetAllComplexityRequest;
import com.ptit.transportationmanagement.client.dto.complexity.GetAllComplexityResponse;
import com.ptit.transportationmanagement.client.dto.driver.GetListDriverPagingRequest;
import com.ptit.transportationmanagement.client.dto.driver.GetListDriverPagingResponse;
import com.ptit.transportationmanagement.service.CoachService;
import com.ptit.transportationmanagement.service.ComplexityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/complexity")
public class ComplexityResource {

    private final Logger LOG = LoggerFactory.getLogger(CoachResource.class);

    @Autowired
    private ComplexityService complexityService;


    @PostMapping("/get-all")
    public ResponseEntity<?> getList(@RequestBody GetAllComplexityRequest request){
        try {
            GetAllComplexityResponse response = complexityService.getAll(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error(this.getClass().getName(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
