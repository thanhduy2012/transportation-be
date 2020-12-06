package com.ptit.transportationmanagement.service.mapper;

import com.ptit.transportationmanagement.domain.Trip;
import com.ptit.transportationmanagement.service.dto.TripDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {})
public interface TripMapper extends EntityMapper<TripDTO, Trip>{

}
