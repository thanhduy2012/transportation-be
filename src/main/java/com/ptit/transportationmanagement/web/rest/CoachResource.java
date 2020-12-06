package com.ptit.transportationmanagement.web.rest;

import com.ptit.transportationmanagement.client.dto.coach.*;
import com.ptit.transportationmanagement.service.CoachService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coach")
public class CoachResource {

    private final Logger LOG = LoggerFactory.getLogger(CoachResource.class);

    private  CoachService coachService;

    public CoachResource(CoachService coachService) {
        this.coachService = coachService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateCoachRequest request){
        try {
            CreateCoachResponse response = coachService.create(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error(this.getClass().getName(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/get-all")
    public ResponseEntity<?> getList(@RequestBody GetListCoachPagingRequest request){
        try {
            GetListCoachPagingResponse response = coachService.getAll(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error(this.getClass().getName(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody UpdateCoachRequest request){
        try {
            UpdateCoachResponse response =  coachService.update(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
                LOG.error(this.getClass().getName(), e);
                return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/delete")
    public  ResponseEntity<?> delete(@RequestBody DeleteCoachByIdRequest request){
        try {
            DeleteCoachByIdResponse response = coachService.delete(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error(this.getClass().getName(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
