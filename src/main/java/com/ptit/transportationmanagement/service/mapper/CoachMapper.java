package com.ptit.transportationmanagement.service.mapper;

import com.ptit.transportationmanagement.domain.Coach;
import com.ptit.transportationmanagement.domain.Driver;
import com.ptit.transportationmanagement.service.dto.CoachDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CoachMapper extends EntityMapper<CoachDTO, Coach> {


}
