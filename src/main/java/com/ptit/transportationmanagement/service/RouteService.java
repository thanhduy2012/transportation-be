package com.ptit.transportationmanagement.service;

import com.ptit.transportationmanagement.client.dto.route.*;
import com.ptit.transportationmanagement.common.utils.OptimizedPageUtils;
import com.ptit.transportationmanagement.common.utils.StringUtils;
import com.ptit.transportationmanagement.domain.Route;
import com.ptit.transportationmanagement.repository.ComplexityRepository;
import com.ptit.transportationmanagement.repository.RouteRepository;
import com.ptit.transportationmanagement.service.dto.RouteDTO;
import com.ptit.transportationmanagement.service.mapper.ComplexityMapper;
import com.ptit.transportationmanagement.service.mapper.RouteMapper;
import lombok.AllArgsConstructor;
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
public class RouteService {
    private final Logger LOG = LoggerFactory.getLogger(RouteService.class);

    private final RouteRepository routeRepository;

    private final ComplexityRepository complexityRepository;

    private final ComplexityMapper complexityMapper;

    private final RouteMapper routeMapper;

    public CreateRouteResponse create(CreateRouteRequest request) throws Exception {
        CreateRouteResponse response = new CreateRouteResponse();


        if(request == null){
            throw new Exception("request not null !");
        }
        if(request.getRoute() == null ){
            throw  new Exception("Route not null !");
        }

        System.out.println("request "+request.getRoute());
        Route route = routeMapper.toEntity(request.getRoute());
     ;

        route.setCreatedDate(LocalDate.now());
        route.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
        Route save = routeRepository.save(route);

        RouteDTO routeDTO = routeMapper.toDto(save);
        routeDTO.setComplexity(complexityMapper.toDto(complexityRepository.findById(route.getComplexity().getId()).get()));
        response.setRoute(routeDTO);
        return response;
    }

    public GetListRoutePagingResponse getAll(GetListRoutePagingRequest request) throws Exception {
        GetListRoutePagingResponse response = new GetListRoutePagingResponse();
        if(null == request)  throw new Exception("request not null !");
        if (request.getPageNumber() < 1)
            request.setPageNumber(1);
        if (request.getPageSize() < 1)
            request.setPageSize(10);

        RouteDTO route = request.getRoute();

        Pageable pageable = PageRequest.of(request.getPageNumber() - 1, request.getPageSize());
        Page<Route> paging = routeRepository.findAllRoute(
                pageable,
                !(StringUtils.isEmpty(route.getFirstLocation())) ? route.getFirstLocation() : null,
                !(StringUtils.isEmpty(route.getLastLocation())) ? route.getLastLocation() : null,
                route.getLength()
        );

        response.setPage(OptimizedPageUtils.convert(paging));

        return response;


    }

    public UpdateRouteResponse update(UpdateRouteRequest request) throws Exception {
        if(null == request ){
            throw new Exception("request not null !");
        }
        Optional<Route> byId = routeRepository.findById(request.getRoute().getId());
        if(!byId.isPresent()) throw new Exception("Route is not existed !");

        Route route= byId.get();

        route.setFirstLocation(
                (!StringUtils.isEmpty(request.getRoute().getFirstLocation())) ? request.getRoute().getFirstLocation() : route.getFirstLocation()
        );
        route.setLastLocation(
                (!StringUtils.isEmpty(request.getRoute().getLastLocation())) ? request.getRoute().getLastLocation() : route.getLastLocation()
        );
        route.setLength(
                !(request.getRoute().getLength() == null) ? request.getRoute().getLength() : route.getLength()
        );

        route.setComplexity(
                !(request.getRoute().getComplexity() == null) ? complexityMapper.toEntity(request.getRoute().getComplexity())  : route.getComplexity()
        );

        route.setUpdatedDate(LocalDate.now());
        route.setUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());

        Route save = routeRepository.save(route);

        UpdateRouteResponse response = new UpdateRouteResponse();
        RouteDTO routeDTO = routeMapper.toDto(save);
        routeDTO.setComplexity(complexityMapper.toDto(complexityRepository.findById(route.getComplexity().getId()).get()));
        response.setRoute(routeDTO);
        return response;

    }

    public DeleteRouteByIdResponse delete(DeleteRouteByIdRequest request) throws Exception {
        if(request == null) throw new Exception("Request not null");
        if(request.getId() == null) throw  new Exception("Id not null");
        Optional<Route> byId = routeRepository.findById(request.getId());

        if(!byId.isPresent())throw new Exception("Route does not existed !!!");

        Route trip = byId.get();
        routeRepository.deleteById(request.getId());

        DeleteRouteByIdResponse response = new DeleteRouteByIdResponse();
        response.setRoute(routeMapper.toDto(trip));

        return response;

    }
}
