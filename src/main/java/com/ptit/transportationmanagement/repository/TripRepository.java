package com.ptit.transportationmanagement.repository;

import com.ptit.transportationmanagement.domain.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    @Query("select t from Trip t " +
            "where 1=1 " +
            "and (lower(t.code) like lower(concat('%', :code, '%')) or :code is null ) " +
            "and (t.numberGuest = :numberGuest or :numberGuest is null ) " +
            "and (t.price = :price or :price is null ) " +
            "and (t.status = :status or :status is null ) "
    )
    Page<Trip> findAllTrip(
            Pageable pageable,
            @Param("code") String code,
            @Param("numberGuest") Integer numberGuest,
            @Param("price") Double price,
            @Param("status") Integer status
    );
}
