package com.ptit.transportationmanagement.web.rest;

import com.ptit.transportationmanagement.client.dto.trip.*;
import com.ptit.transportationmanagement.service.TripService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trip")
public class TripResource {

    private final Logger LOG = LoggerFactory.getLogger(DriverResource.class);

    private final TripService tripService;

    public TripResource (TripService tripService) {
        this.tripService= tripService;
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateTripRequest request){
        try {
            CreateTripResponse response = tripService.create(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error(this.getClass().getName(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/get-all")
    public ResponseEntity<?> getList(@RequestBody GetListTripPagingRequest request){
        try {
            GetListTripPagingResponse response = tripService.getAll(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error(this.getClass().getName(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody UpdateTripRequest request){
        try {
            UpdateTripResponse response =  tripService.update(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error(this.getClass().getName(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/delete")
    public  ResponseEntity<?> delete(@RequestBody DeleteTripByIdRequest request){
        try {
            DeleteTripByIdResponse response = tripService.delete(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error(this.getClass().getName(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
