package com.ptit.transportationmanagement.service;

import com.ptit.transportationmanagement.client.dto.coach.GetListCoachPagingRequest;
import com.ptit.transportationmanagement.client.dto.coach.GetListCoachPagingResponse;
import com.ptit.transportationmanagement.client.dto.complexity.GetAllComplexityRequest;
import com.ptit.transportationmanagement.client.dto.complexity.GetAllComplexityResponse;
import com.ptit.transportationmanagement.common.utils.OptimizedPageUtils;
import com.ptit.transportationmanagement.common.utils.StringUtils;
import com.ptit.transportationmanagement.domain.Coach;
import com.ptit.transportationmanagement.domain.Complexity;
import com.ptit.transportationmanagement.repository.CoachRepository;
import com.ptit.transportationmanagement.repository.ComplexityRepository;
import com.ptit.transportationmanagement.service.dto.CoachDTO;
import com.ptit.transportationmanagement.service.dto.ComplexityDTO;
import com.ptit.transportationmanagement.service.mapper.CoachMapper;
import com.ptit.transportationmanagement.service.mapper.ComplexityMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class ComplexityService {


    private final Logger LOG = LoggerFactory.getLogger(CoachService.class);

    private final ComplexityRepository complexityRepository;

    private final ComplexityMapper complexityMapper;



    public GetAllComplexityResponse getAll(GetAllComplexityRequest request) throws Exception {
        GetAllComplexityResponse response = new GetAllComplexityResponse();
        if(null == request)  throw new Exception("request not null !");


        List<Complexity> all = complexityRepository.findAll();

        List<ComplexityDTO> complexityDTOS = complexityMapper.toDto(all);

        response.setComplexities(complexityDTOS);

        return response;


    }
}
