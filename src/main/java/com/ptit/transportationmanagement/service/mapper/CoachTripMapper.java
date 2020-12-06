package com.ptit.transportationmanagement.service.mapper;

import com.ptit.transportationmanagement.domain.AccountRole;
import com.ptit.transportationmanagement.domain.AccountRolePK;
import com.ptit.transportationmanagement.domain.CoachTrip;
import com.ptit.transportationmanagement.domain.CoachTripPK;
import com.ptit.transportationmanagement.service.dto.AccountRoleDTO;
import com.ptit.transportationmanagement.service.dto.CoachTripDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface CoachTripMapper {

    @Mapping(source = "coach.id", target = "id.coachId")
    @Mapping(source = "trip.id", target = "id.tripId")
    @Mapping(source = "coach.id", target = "coachId")
    @Mapping(source = "trip.id", target = "tripId")
    CoachTripDTO toDto(CoachTrip coachTrip);

    @Mapping(source = "id.coachId", target = "coach.id")
    @Mapping(source = "id.tripId", target = "trip.id")
    CoachTrip toEntity(CoachTripDTO coachTripDTO);

}
