package com.ptit.transportationmanagement.repository;

import com.ptit.transportationmanagement.domain.Coach;
import com.ptit.transportationmanagement.domain.Complexity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplexityRepository  extends JpaRepository<Complexity, Long> {
}
