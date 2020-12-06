package com.ptit.transportationmanagement.web.rest;

import com.ptit.transportationmanagement.client.dto.driver.*;
import com.ptit.transportationmanagement.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/driver")
public class DriverResource {

    private final Logger LOG = LoggerFactory.getLogger(DriverResource.class);

    private final DriverService driverService;

    public DriverResource(DriverService driverService) {
        this.driverService = driverService;
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateDriverRequest request){
        try {
            CreateDriverResponse response = driverService.create(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error(this.getClass().getName(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/get-all")
    public ResponseEntity<?> getList(@RequestBody GetListDriverPagingRequest request){
        try {
            GetListDriverPagingResponse response = driverService.getAll(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error(this.getClass().getName(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody UpdateDriverRequest request){
        try {
            UpdateDriverResponse response =  driverService.update(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error(this.getClass().getName(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/delete")
    public  ResponseEntity<?> delete(@RequestBody DeleteDriverByIdRequest request){
        try {
            DeleteDriverByIdResponse response = driverService.delete(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error(this.getClass().getName(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
