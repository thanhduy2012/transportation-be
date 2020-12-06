package com.ptit.transportationmanagement.service.mapper;

import com.ptit.transportationmanagement.domain.Driver;
import com.ptit.transportationmanagement.service.dto.DriverDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface DriverMapper extends EntityMapper<DriverDTO,Driver> {
}
