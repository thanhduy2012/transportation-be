package com.ptit.transportationmanagement.service.mapper;

import com.ptit.transportationmanagement.domain.DriverTrip;
import com.ptit.transportationmanagement.domain.DriverTripPK;
import com.ptit.transportationmanagement.service.dto.DriverTripDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface DriverTripMapper extends EntityMapper<DriverTripDTO, DriverTrip> {

    @Mapping(source = "driver.id", target = "id.driverId")
    @Mapping(source = "trip.id", target = "id.tripId")
    @Mapping(source = "driver.id", target = "driverId")
    @Mapping(source = "trip.id", target = "tripId")
    DriverTripDTO toDto(DriverTrip driverTrip);

    @Mapping(source = "id.driverId", target = "driver.id")
    @Mapping(source = "id.tripId", target = "trip.id")
    DriverTrip toEntity(DriverTripDTO driverTripDTO);
}
