package com.ptit.transportationmanagement.web.rest;

import com.ptit.transportationmanagement.client.dto.route.*;
import com.ptit.transportationmanagement.service.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/route")
public class RouteResource {
    private final Logger LOG = LoggerFactory.getLogger(RouteResource.class);

    private final RouteService routeService;

    public RouteResource (RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateRouteRequest request){
        try {
            CreateRouteResponse response = routeService.create(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error(this.getClass().getName(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/get-all")
    public ResponseEntity<?> getList(@RequestBody GetListRoutePagingRequest request){
        try {
            GetListRoutePagingResponse response = routeService.getAll(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error(this.getClass().getName(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody UpdateRouteRequest request){
        try {
            UpdateRouteResponse response =  routeService.update(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error(this.getClass().getName(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/delete")
    public  ResponseEntity<?> delete(@RequestBody DeleteRouteByIdRequest request){
        try {
            DeleteRouteByIdResponse response = routeService.delete(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error(this.getClass().getName(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
