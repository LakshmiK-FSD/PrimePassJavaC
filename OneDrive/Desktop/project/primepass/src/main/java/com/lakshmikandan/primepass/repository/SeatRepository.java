package com.lakshmikandan.primepass.repository;

import com.lakshmikandan.primepass.model.SeatModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<SeatModel,Integer> {
//
//    @Modifying
//    @Transactional
//    @Query(value = "update seat_model set status = 'BOOKED' where setid=:seatId ;",nativeQuery = true)
//    int updateSeatStatus(int seatId);
}
