package com.ptit.transportationmanagement.repository;

import com.ptit.transportationmanagement.domain.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
    @Query("select d from Driver d  " +
            "where 1=1 " +
            "and (lower(d.name) like lower(concat('%', :name, '%')) or :name is null ) " +
            "and (lower(d.identityCard) like lower(concat('%', :identityCard, '%')) or :identityCard is null ) " +
            "and (lower(d.licenseDriver) like lower(concat('%', :licenseDriver, '%')) or :licenseDriver is null ) " +
            "and (lower(d.typeLicenseDriver) like lower(concat('%', :typeLicenseDriver, '%')) or :typeLicenseDriver is null ) " +
            "and (d.seniority = :seniority or :seniority is null ) " +
            "and (lower(d.address) like lower(concat('%', :address, '%')) or :address is null ) " +
            "and (d.dateOfBirth >= :fromDOB or :fromDOB is null) " +
            "and (d.dateOfBirth <= :toDOB or :toDOB is null)"
    )
    Page<Driver> findAllDriver(
            Pageable pageable,
            @Param("name") String name,
            @Param("identityCard") String identityCard,
            @Param("licenseDriver") String licenseDriver,
            @Param("typeLicenseDriver") String typeLicenseDriver,
            @Param("address") String address,
            @Param("fromDOB") LocalDate fromDOB,
            @Param("toDOB") LocalDate toDOB,
            @Param("seniority") Integer seniority
    );

}
