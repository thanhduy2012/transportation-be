package com.ptit.transportationmanagement.service;

import com.ptit.transportationmanagement.client.dto.coach.*;
import com.ptit.transportationmanagement.common.domain.OptimizedPage;
import com.ptit.transportationmanagement.common.utils.OptimizedPageUtils;
import com.ptit.transportationmanagement.common.utils.StringUtils;
import com.ptit.transportationmanagement.domain.Coach;
import com.ptit.transportationmanagement.domain.CoachTrip;
import com.ptit.transportationmanagement.repository.CoachRepository;
import com.ptit.transportationmanagement.repository.CoachTripRepository;
import com.ptit.transportationmanagement.service.dto.CoachDTO;
import com.ptit.transportationmanagement.service.dto.SalaryCoachDTO;
import com.ptit.transportationmanagement.service.mapper.CoachMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CoachService {

    private final Logger LOG = LoggerFactory.getLogger(CoachService.class);

    private final CoachRepository coachRepository;

    private final CoachTripRepository coachTripRepository;


    private final CoachMapper coachMapper;

    public CreateCoachResponse create(CreateCoachRequest request) throws Exception {
        CreateCoachResponse response = new CreateCoachResponse();

        if(request == null){
            throw new Exception("request not null !");
        }
        if(request.getCoach() == null ){
            throw  new Exception("Coach not null !");
        }
        Coach coach = coachMapper.toEntity(request.getCoach());
        coach.setCreatedDate(LocalDate.now());
        coach.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
        Coach save = coachRepository.save(coach);

        response.setCoach(coachMapper.toDto(save));
        return response;
    }

    public GetListCoachPagingResponse getAll(GetListCoachPagingRequest request) throws Exception {
        GetListCoachPagingResponse response = new GetListCoachPagingResponse();
        if(null == request)  throw new Exception("request not null !");
        if (request.getPageNumber() < 1)
            request.setPageNumber(1);
        if (request.getPageSize() < 1)
            request.setPageSize(10);

        CoachDTO coach = request.getCoach();

        Pageable pageable = PageRequest.of(request.getPageNumber() - 1, request.getPageSize(), Sort.Direction.DESC, "id");
        Page<Coach> paging = coachRepository.findAllCoach(
                pageable,
                !(StringUtils.isEmpty(coach.getLicensePlate())) ? coach.getLicensePlate() : null,
                !(StringUtils.isEmpty(coach.getColor())) ? coach.getColor() : null,
                !(StringUtils.isEmpty(coach.getManufacturer())) ? coach.getManufacturer() : null,
                !(StringUtils.isEmpty(coach.getModel()))? coach.getModel() : null,
                coach.getSeatNumber(),
                coach.getFromLastDateMaintenance(),
                coach.getToLastDateMaintenance()
        );

        response.setPage(OptimizedPageUtils.convert(paging));

        return response;


    }

    public UpdateCoachResponse update(UpdateCoachRequest request) throws Exception {
        if(null == request ){
            throw new Exception("request not null !");
        }
        Optional<Coach> byId = coachRepository.findById(request.getCoach().getId());
        if(!byId.isPresent()) throw new Exception("coach is not existed !");

        Coach coach = byId.get();

        coach.setColor(
                (!StringUtils.isEmpty(request.getCoach().getColor())) ? request.getCoach().getColor() : coach.getColor()
        );
        coach.setLastDateMaintenance(
                (request.getCoach().getLastDateMaintenance() == null) ? request.getCoach().getLastDateMaintenance() : coach.getLastDateMaintenance()
        );
        coach.setLicensePlate(
                (!StringUtils.isEmpty(request.getCoach().getLicensePlate())) ? request.getCoach().getLicensePlate() : coach.getLicensePlate()
        );
        coach.setManufacturer(
                (!StringUtils.isEmpty(request.getCoach().getManufacturer())) ? request.getCoach().getManufacturer() : coach.getManufacturer()
        );
        coach.setSeatNumber(
                (request.getCoach().getSeatNumber() == null) ? request.getCoach().getSeatNumber() : coach.getSeatNumber()
        );

        coach.setNumOfmaintain(
                (request.getCoach().getNumOfmaintain() == null) ? request.getCoach().getNumOfmaintain() : coach.getNumOfmaintain()
        );
        coach.setModel(
                (!StringUtils.isEmpty(request.getCoach().getModel())) ? request.getCoach().getModel() : coach.getModel()
        );
        coach.setUpdatedDate(LocalDate.now());
        coach.setUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());

        Coach save = coachRepository.save(coach);

        UpdateCoachResponse response = new UpdateCoachResponse();
        response.setCoach(coachMapper.toDto(save));

        return response;

    }

    public DeleteCoachByIdResponse delete(DeleteCoachByIdRequest request) throws Exception {
        if(request == null) throw new Exception("Request not null");
        if(request.getId() == null) throw  new Exception("Id not null");
        Optional<Coach> byId = coachRepository.findById(request.getId());

        if(!byId.isPresent())throw new Exception("Coach does not existed !!!");

        Coach coach = byId.get();
        coachRepository.deleteById(request.getId());

        DeleteCoachByIdResponse response = new DeleteCoachByIdResponse();
        response.setCoach(coachMapper.toDto(coach));

        return response;

    }


    public GetSalaryResponse getSalary(GetSalaryRequest request) throws Exception {

        if(request == null) throw new Exception("Request not null");

        SalaryCoachDTO salaryCoachDTO = new SalaryCoachDTO();

        Coach coach = coachRepository.findById(request.getCoachId()).get();

        List<CoachTrip> byCoachId = coachTripRepository.findByCoachIdWithDate(request.getCoachId(),request.getFromDate(),request.getToDate());


        System.out.println("size : " + byCoachId.size());
        Double distance = 0D;
        Double salary = 0D;

        for (CoachTrip i :byCoachId
             ) {
            distance += i.getDistance();

            salary += i.getSalary();
        }


        salaryCoachDTO.setCoach(coachMapper.toDto(coach));
        salaryCoachDTO.setNumberTrip(byCoachId.size());
        salaryCoachDTO.setDistance(distance);
        salaryCoachDTO.setSalary(salary);
        GetSalaryResponse response = new GetSalaryResponse();
        response.setSalaryCoachDTO(salaryCoachDTO);

        return response;

    }
}
