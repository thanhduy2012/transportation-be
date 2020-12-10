package com.ptit.transportationmanagement.service.mapper;

import com.ptit.transportationmanagement.domain.Route;
import com.ptit.transportationmanagement.service.dto.RouteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring", uses = {})
public interface RouteMapper extends EntityMapper<RouteDTO, Route>{
    RouteDTO toDto(Route route);
}
