package com.ptit.transportationmanagement.repository;

import com.ptit.transportationmanagement.domain.Coach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
    @Query("select c from Coach c  " +
            "where 1=1 " +
            "and (lower(c.licensePlate) like lower(concat('%', :licensePlate, '%')) or :licensePlate is null ) " +
            "and (lower(c.color) like lower(concat('%', :color, '%')) or :color is null ) " +
            "and (lower(c.manufacturer) like lower(concat('%', :manufacturer, '%')) or :manufacturer is null ) " +
            "and (lower(c.model) like lower(concat('%', :model, '%')) or :model is null ) " +
            "and (c.seatNumber = :seatNumber or :seatNumber is null ) " +
            "and (lower(c.manufacturer) like lower(concat('%', :manufacturer, '%')) or :manufacturer is null ) " +
            "and (c.lastDateMaintenance >= :fromLastDateMaintenance or :fromLastDateMaintenance is null) " +
            "and (c.lastDateMaintenance <= :toLastDateMaintenance or :toLastDateMaintenance is null)"
    )
    Page<Coach> findAllCoach(
            Pageable pageable,
            @Param("licensePlate") String licensePlate,
            @Param("color") String color,
            @Param("manufacturer") String manufacturer,
            @Param("model") String model,
            @Param("seatNumber") Integer seatNumber,
            @Param("fromLastDateMaintenance") LocalDate fromLastDateMaintenance,
            @Param("toLastDateMaintenance") LocalDate toLastDateMaintenance
    );


}
