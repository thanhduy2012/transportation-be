package com.ptit.transportationmanagement.repository;

import com.ptit.transportationmanagement.domain.CoachTrip;
import com.ptit.transportationmanagement.domain.CoachTripPK;
import com.ptit.transportationmanagement.domain.RouteTrip;
import com.ptit.transportationmanagement.domain.RouteTripPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RouteTripRepository   extends JpaRepository<RouteTrip, RouteTripPK> {
    @Query("select d from RouteTrip  d " +
            "where  1=1 " +
            "and d.trip.id = :tripId " )
    Optional<RouteTrip> findByTripId(Long tripId);
}
