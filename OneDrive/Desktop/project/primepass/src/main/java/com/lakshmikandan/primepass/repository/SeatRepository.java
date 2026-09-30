package com.lakshmikandan.primepass.repository;

import com.lakshmikandan.primepass.model.SeatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<SeatModel,Integer> {
}
