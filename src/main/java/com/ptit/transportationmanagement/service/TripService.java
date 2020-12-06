package com.ptit.transportationmanagement.service;

import com.ptit.transportationmanagement.client.dto.driver.GetListDriverPagingRequest;
import com.ptit.transportationmanagement.client.dto.driver.GetListDriverPagingResponse;
import com.ptit.transportationmanagement.client.dto.trip.*;
import com.ptit.transportationmanagement.common.utils.OptimizedPageUtils;
import com.ptit.transportationmanagement.common.utils.StringUtils;
import com.ptit.transportationmanagement.domain.Trip;
import com.ptit.transportationmanagement.repository.TripRepository;
import com.ptit.transportationmanagement.service.dto.TripDTO;
import com.ptit.transportationmanagement.service.mapper.TripMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class TripService {
    private final Logger LOG = LoggerFactory.getLogger(TripService.class);

    private final TripRepository tripRepository;

    private final TripMapper tripMapper;

    public CreateTripResponse create(CreateTripRequest request) throws Exception {
        CreateTripResponse response = new CreateTripResponse();


        if(request == null){
            throw new Exception("request not null !");
        }
        if(request.getTrip() == null ){
            throw  new Exception("Driver not null !");
        }
        Trip trip= tripMapper.toEntity(request.getTrip());
        trip.setCreatedDate(LocalDate.now());
        trip.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
        Trip save = tripRepository.save(trip);

        response.setTrip(tripMapper.toDto(save));
        return response;
    }

    public GetListTripPagingResponse getAll(GetListTripPagingRequest request) throws Exception {
        GetListTripPagingResponse response = new GetListTripPagingResponse();
        if(null == request)  throw new Exception("request not null !");
        if (request.getPageNumber() < 1)
            request.setPageNumber(1);
        if (request.getPageSize() < 1)
            request.setPageSize(10);

        TripDTO trip = request.getTrip();

        Pageable pageable = PageRequest.of(request.getPageNumber() - 1, request.getPageSize());
        Page<Trip> paging = tripRepository.findAllTrip(
                pageable,
                !(StringUtils.isEmpty(trip.getCode())) ? trip.getCode() : null,
                trip.getNumberGuest(),
                trip.getPrice(),
                trip.getStatus()
        );

        response.setPage(OptimizedPageUtils.convert(paging));

        return response;


    }

    public UpdateTripResponse update(UpdateTripRequest request) throws Exception {
        if(null == request ){
            throw new Exception("request not null !");
        }
        Optional<Trip> byId = tripRepository.findById(request.getTrip().getId());
        if(!byId.isPresent()) throw new Exception("Driver is not existed !");

        Trip trip= byId.get();

        trip.setCode(
                (!StringUtils.isEmpty(request.getTrip().getCode())) ? request.getTrip().getCode() : trip.getCode()
        );
        trip.setPrice(
                !(request.getTrip().getPrice() == null) ? request.getTrip().getPrice() : trip.getPrice()
        );
        trip.setNumberGuest(
                !(request.getTrip().getNumberGuest() == null) ? request.getTrip().getNumberGuest() : trip.getNumberGuest()
        );
        trip.setStatus(
                !(request.getTrip().getStatus() == null) ? request.getTrip().getStatus():trip.getStatus()
        );

        trip.setUpdatedDate(LocalDate.now());
        trip.setUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());

        Trip save = tripRepository.save(trip);

        UpdateTripResponse response = new UpdateTripResponse();
        response.setTrip(tripMapper.toDto(save));

        return response;

    }

    public DeleteTripByIdResponse delete(DeleteTripByIdRequest request) throws Exception {
        if(request == null) throw new Exception("Request not null");
        if(request.getId() == null) throw  new Exception("Id not null");
        Optional<Trip> byId = tripRepository.findById(request.getId());

        if(!byId.isPresent())throw new Exception("Trip does not existed !!!");

        Trip trip = byId.get();
        tripRepository.deleteById(request.getId());

        DeleteTripByIdResponse response = new DeleteTripByIdResponse();
        response.setTrip(tripMapper.toDto(trip));

        return response;

    }

}
