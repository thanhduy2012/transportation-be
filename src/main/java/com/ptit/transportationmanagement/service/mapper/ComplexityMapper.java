package com.ptit.transportationmanagement.service.mapper;

import com.ptit.transportationmanagement.domain.Complexity;
import com.ptit.transportationmanagement.service.dto.ComplexityDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ComplexityMapper  extends  EntityMapper<ComplexityDTO, Complexity>{

}
