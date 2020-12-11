package com.ptit.transportationmanagement.repository;

import com.ptit.transportationmanagement.domain.CoachTrip;
import com.ptit.transportationmanagement.domain.CoachTripPK;
import com.ptit.transportationmanagement.domain.Complexity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CoachTripRepository  extends JpaRepository<CoachTrip, CoachTripPK> {
    @Query("select d from CoachTrip  d " +
            "where  1=1 " +
            "and d.trip.id = :tripId " )
    Optional<CoachTrip> findByTripId(Long tripId);

    @Query("select d from CoachTrip  d " +
            "where  1=1 " +
            "and d.coach.id = :coachId " +
            "and (d.date >= :fromDate or :fromDate is null) " +
            "and (d.date <= :toDate or :toDate is null)" )
    List<CoachTrip> findByCoachIdWithDate(
            @Param("coachId")Long coachId,
            @Param("fromDate") LocalDate fromDate,
            @Param("toDate") LocalDate toDate);
}
