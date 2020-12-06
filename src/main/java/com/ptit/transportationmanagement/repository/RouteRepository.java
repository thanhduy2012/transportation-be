package com.ptit.transportationmanagement.repository;

import com.ptit.transportationmanagement.domain.Route;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {
    @Query("select r from Route r " +
            "where 1=1 " +
            "and (lower(r.firstLocation) like lower(concat('%', :firstLocation, '%')) or :firstLocation is null ) " +
            "and (lower(r.lastLocation) like lower(concat('%', :lastLocation, '%')) or :lastLocation is null ) " +
            "and (r.length= :length or :length is null ) "
    )
    Page<Route> findAllRoute(
            Pageable pageable,
            @Param("firstLocation") String firstLocation,
            @Param("lastLocation") String lastLocation,
            @Param("length") Long length
    );

}
