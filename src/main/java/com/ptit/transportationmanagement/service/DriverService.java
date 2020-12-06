package com.ptit.transportationmanagement.service;

import com.ptit.transportationmanagement.client.dto.driver.*;
import com.ptit.transportationmanagement.common.utils.OptimizedPageUtils;
import com.ptit.transportationmanagement.common.utils.StringUtils;
import com.ptit.transportationmanagement.domain.Driver;
import com.ptit.transportationmanagement.repository.DriverRepository;
import com.ptit.transportationmanagement.service.dto.DriverDTO;
import com.ptit.transportationmanagement.service.mapper.DriverMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class DriverService {

    private final Logger LOG = LoggerFactory.getLogger(DriverService.class);

    private final DriverRepository driverRepository;

    private final DriverMapper driverMapper;

    public CreateDriverResponse create(CreateDriverRequest request) throws Exception {
        CreateDriverResponse response = new CreateDriverResponse();

        if(request == null){
            throw new Exception("request not null !");
        }
        if(request.getDriver() == null ){
            throw  new Exception("Driver not null !");
        }
        Driver driver = driverMapper.toEntity(request.getDriver());
        driver.setCreatedDate(LocalDate.now());
        driver.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
        Driver save = driverRepository.save(driver);

        response.setDriver(driverMapper.toDto(save));
        return response;
    }

    public GetListDriverPagingResponse getAll(GetListDriverPagingRequest request) throws Exception {
        GetListDriverPagingResponse response = new GetListDriverPagingResponse();
        if(null == request)  throw new Exception("request not null !");
        if (request.getPageNumber() < 1)
            request.setPageNumber(1);
        if (request.getPageSize() < 1)
            request.setPageSize(10);

        DriverDTO driver = request.getDriver();

        Pageable pageable = PageRequest.of(request.getPageNumber() - 1, request.getPageSize());
        Page<Driver> paging = driverRepository.findAllDriver(
                pageable,
                !(StringUtils.isEmpty(driver.getName())) ? driver.getName() : null,
                !(StringUtils.isEmpty(driver.getIdentityCard())) ? driver.getIdentityCard() : null,
                !(StringUtils.isEmpty(driver.getLicenseDriver())) ? driver.getLicenseDriver() : null,
                !(StringUtils.isEmpty(driver.getTypeLicenseDriver()))? driver.getTypeLicenseDriver() : null,
                !(StringUtils.isEmpty(driver.getAddress()))? driver.getAddress() : null,
                driver.getFromDOB(),
                driver.getToDOB(),
                driver.getSeniority()
        );

        response.setPage(OptimizedPageUtils.convert(paging));

        return response;


    }

    public UpdateDriverResponse update(UpdateDriverRequest request) throws Exception {
        if(null == request ){
            throw new Exception("request not null !");
        }
        Optional<Driver> byId = driverRepository.findById(request.getDriver().getId());
        if(!byId.isPresent()) throw new Exception("Driver is not existed !");

        Driver driver = byId.get();

        driver.setName(
                (!StringUtils.isEmpty(request.getDriver().getName())) ? request.getDriver().getName() : driver.getName()
        );
        driver.setAddress(
                (request.getDriver().getAddress() == null) ? request.getDriver().getAddress() : driver.getAddress()
        );
        driver.setIdentityCard(
                (!StringUtils.isEmpty(request.getDriver().getIdentityCard())) ? request.getDriver().getIdentityCard() : driver.getIdentityCard()
        );
        driver.setLicenseDriver(
                (!StringUtils.isEmpty(request.getDriver().getLicenseDriver())) ? request.getDriver().getLicenseDriver() : driver.getLicenseDriver()
        );
        driver.setTypeLicenseDriver(
                (!StringUtils.isEmpty(request.getDriver().getTypeLicenseDriver())) ? request.getDriver().getTypeLicenseDriver() : driver.getTypeLicenseDriver()
        );
        driver.setDateOfBirth(
                (request.getDriver().getDateOfBirth() == null) ? request.getDriver().getDateOfBirth() : driver.getDateOfBirth()
        );
        driver.setSeniority(
                (request.getDriver().getSeniority() == null) ? request.getDriver().getSeniority():request.getDriver().getSeniority()
        );

        driver.setUpdatedDate(LocalDate.now());
        driver.setUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());

        Driver save = driverRepository.save(driver);

        UpdateDriverResponse response = new UpdateDriverResponse();
        response.setDriver(driverMapper.toDto(save));

        return response;

    }

    public DeleteDriverByIdResponse delete(DeleteDriverByIdRequest request) throws Exception {
        if(request == null) throw new Exception("Request not null");
        if(request.getId() == null) throw  new Exception("Id not null");
        Optional<Driver> byId = driverRepository.findById(request.getId());

        if(!byId.isPresent())throw new Exception("Driver does not existed !!!");

        Driver driver = byId.get();
        driverRepository.deleteById(request.getId());

        DeleteDriverByIdResponse response = new DeleteDriverByIdResponse();
        response.setDriver(driverMapper.toDto(driver));

        return response;

    }
}
