package com.ptit.transportationmanagement.service;

import com.ptit.transportationmanagement.client.dto.driver.GetListDriverPagingRequest;
import com.ptit.transportationmanagement.client.dto.driver.GetListDriverPagingResponse;
import com.ptit.transportationmanagement.client.dto.trip.*;
import com.ptit.transportationmanagement.common.utils.OptimizedPageUtils;
import com.ptit.transportationmanagement.common.utils.StringUtils;
import com.ptit.transportationmanagement.domain.*;
import com.ptit.transportationmanagement.repository.*;
import com.ptit.transportationmanagement.service.dto.TripDTO;
import com.ptit.transportationmanagement.service.mapper.CoachMapper;
import com.ptit.transportationmanagement.service.mapper.DriverMapper;
import com.ptit.transportationmanagement.service.mapper.RouteMapper;
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

    private final DriverTripRepository driverTripRepository;

    private final DriverRepository driverRepository;

    private final DriverMapper driverMapper;

    private final RouteRepository routeRepository;

    private final RouteMapper routeMapper;

    private final CoachRepository coachRepository;

    private final CoachMapper coachMapper;

    private final RouteTripRepository routeTripRepository;

    private final CoachTripRepository coachTripRepository;

    private final TripMapper tripMapper;

    public CreateTripResponse create(CreateTripRequest request) throws Exception {
        CreateTripResponse response = new CreateTripResponse();


        if(request == null){
            throw new Exception("request not null !");
        }
        if(request.getTrip() == null ){
            throw  new Exception("Driver not null !");
        }

        System.out.println("Request : " + request);




        Trip trip= tripMapper.toEntity(request.getTrip());
        trip.setCreatedDate(LocalDate.now());
        trip.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
        trip.setDate(request.getTrip().getDate());
        Trip save = tripRepository.save(trip);



        Driver mainDriver = new Driver();
        mainDriver.setId(request.getTrip().getMainDriver().getId());

        Driver supDriver = new Driver();
        supDriver.setId(request.getTrip().getSupDriver().getId());

        Coach coach = new Coach();
        coach.setId(request.getTrip().getCoach().getId());

        Route route = new Route();
        route.setId(request.getTrip().getRoute().getId());


        DriverTrip mainDriverTrip = new DriverTrip();
        DriverTripPK mainDriverTripPK = new DriverTripPK();
        mainDriverTripPK.setTripId(trip.getId());
        mainDriverTripPK.setDriverId(request.getTrip().getMainDriver().getId());
        mainDriverTrip.setId(mainDriverTripPK);
        mainDriverTrip.setDriver(mainDriver);
        mainDriverTrip.setTrip(trip);
        mainDriverTrip.setPosition(1);

        Route rt = routeRepository.findById(request.getTrip().getRoute().getId()).get();
        mainDriverTrip.setSalary((request.getTrip().getSalary())*rt.getComplexity().getCoefficientSalary());
        mainDriverTrip.setSalary(request.getTrip().getSalary());
        mainDriverTrip.setDate(request.getTrip().getDate());

        DriverTrip supDriverTrip = new DriverTrip();
        DriverTripPK supDriverTripPK = new DriverTripPK();
        supDriverTripPK.setTripId(trip.getId());
        supDriverTripPK.setDriverId(request.getTrip().getSupDriver().getId());
        supDriverTrip.setId(supDriverTripPK);
        supDriverTrip.setTrip(trip);
        supDriverTrip.setDriver(supDriver);
        supDriverTrip.setPosition(0);

        supDriverTrip.setSalary((request.getTrip().getSalary()/2)*rt.getComplexity().getCoefficientSalary());
        supDriverTrip.setDate(request.getTrip().getDate());

        CoachTrip coachTrip = new CoachTrip();
        CoachTripPK coachTripPK = new CoachTripPK();
        coachTripPK.setCoachId(request.getTrip().getCoach().getId());
        coachTripPK.setTripId(trip.getId());
        coachTrip.setId(coachTripPK);
        coachTrip.setCoach(coach);
        coachTrip.setTrip(trip);
        coachTrip.setSalary(request.getTrip().getNumberGuest()*request.getTrip().getPrice());
        coachTrip.setDate(request.getTrip().getDate());
        coachTrip.setDistance(Double.valueOf(rt.getLength().toString()));

        Double distanced = rt.getLength()*rt.getComplexity().getCoefficientSalary();
        Coach coach1 = coachRepository.findById(request.getTrip().getCoach().getId()).get();

        int i = (int) (coach1.getNumOfmaintain() - (distanced / 100));
        coach1.setNumOfmaintain(i);
        coachRepository.save(coach1);


        RouteTrip routeTrip = new RouteTrip();
        RouteTripPK routeTripPK = new RouteTripPK();
        routeTripPK.setRouteId(request.getTrip().getRoute().getId());
        routeTripPK.setTripId(trip.getId());
        routeTrip.setId(routeTripPK);
        routeTrip.setRoute(route);
        routeTrip.setTrip(trip);



        driverTripRepository.save(mainDriverTrip);
        driverTripRepository.save(supDriverTrip);
        coachTripRepository.save(coachTrip);
        routeTripRepository.save(routeTrip);

        TripDTO tripDTO = tripMapper.toDto(save);
        tripDTO.setMainDriver(driverMapper.toDto(driverRepository.findById(request.getTrip().getMainDriver().getId()).get()));
        tripDTO.setSupDriver(driverMapper.toDto(driverRepository.findById(request.getTrip().getSupDriver().getId()).get()));
        tripDTO.setCoach(coachMapper.toDto(coachRepository.findById(request.getTrip().getCoach().getId()).get()));
        tripDTO.setRoute(routeMapper.toDto(routeRepository.findById(request.getTrip().getRoute().getId()).get()));
        tripDTO.setSalaryMainDriver(request.getTrip().getSalary());
        tripDTO.setSalarySupDriver(request.getTrip().getSalary()/2);
        response.setTrip(tripDTO);
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
        Page<TripDTO> paging = tripRepository.findAllTrip(
                pageable,
                !(StringUtils.isEmpty(trip.getCode())) ? trip.getCode() : null,
                trip.getNumberGuest(),
                trip.getPrice(),
                trip.getStatus()
        ).map(item->{
            TripDTO tripDTO = tripMapper.toDto(item);


            tripDTO.setCoach(coachMapper.toDto(coachTripRepository.findByTripId(item.getId()).get().getCoach()));
            tripDTO.setRoute(routeMapper.toDto( routeTripRepository.findByTripId(item.getId()).get().getRoute()));

            DriverTrip sDriverTrip = driverTripRepository.findByTripIdAndPosition(item.getId(), 0).get();

            tripDTO.setSupDriver( driverMapper.toDto(sDriverTrip.getDriver()));
            tripDTO.setSalarySupDriver(sDriverTrip.getSalary());

            DriverTrip mDriverTrip = driverTripRepository.findByTripIdAndPosition(item.getId(), 1).get();

            tripDTO.setMainDriver( driverMapper.toDto(mDriverTrip.getDriver()));
            tripDTO.setSalaryMainDriver(mDriverTrip.getSalary());
            tripDTO.setDate(mDriverTrip.getDate());
            return tripDTO;
        });

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
