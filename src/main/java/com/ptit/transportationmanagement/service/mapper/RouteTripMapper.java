package com.ptit.transportationmanagement.service.mapper;

import com.ptit.transportationmanagement.domain.RouteTrip;
import com.ptit.transportationmanagement.domain.RouteTripPK;
import com.ptit.transportationmanagement.service.dto.RouteTripDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {})
public interface RouteTripMapper extends EntityMapper<RouteTripDTO, RouteTrip>{


    @Mapping(source = "route.id", target = "id.routeId")
    @Mapping(source = "trip.id", target = "id.tripId")
    @Mapping(source = "route.id", target = "routeId")
    @Mapping(source = "trip.id", target = "tripId")
    RouteTripDTO toDto(RouteTrip routeTrip);

    @Mapping(source = "id.routeId", target = "route.id")
    @Mapping(source = "id.tripId", target = "trip.id")
    RouteTrip toEntity(RouteTripDTO routeTripDTO);

}
