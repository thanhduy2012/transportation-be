package com.ptit.transportationmanagement.repository;

import com.ptit.transportationmanagement.domain.CoachTrip;
import com.ptit.transportationmanagement.domain.CoachTripPK;
import com.ptit.transportationmanagement.domain.DriverTrip;
import com.ptit.transportationmanagement.domain.DriverTripPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverTripRepository   extends JpaRepository<DriverTrip, DriverTripPK> {
//    @Query("select d from DriverTrip  d " +
//            "where  1=1 " +
//            "and d.trip.id = :tripId " +
//            "and d.position = :position")
    Optional<DriverTrip> findByTripIdAndPosition(Long tripId, Integer position);

    @Query("select d from DriverTrip  d " +
        "where  1=1 " +
        "and d.driver.id = :driverId " +
        "and  SUBSTRING(d.date, 6, 2) = :month")
    List<DriverTrip> findByDriverIdAndMonth(Long driverId, String month);


    List<DriverTrip> findByDriverIdAndPosition(Long driverId, Integer position);
}
