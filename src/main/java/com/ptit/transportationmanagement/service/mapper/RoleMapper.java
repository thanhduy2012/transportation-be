package com.ptit.transportationmanagement.service.mapper;

import com.ptit.transportationmanagement.domain.Role;
import com.ptit.transportationmanagement.service.dto.RoleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface RoleMapper extends EntityMapper<RoleDTO, Role>{
}
