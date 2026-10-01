package com.lakshmikandan.primepass.repository;
import com.lakshmikandan.primepass.model.DateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DateRepository extends JpaRepository<DateModel,Integer> {
    @Query(value = "Select Distinct date from date_model",nativeQuery = true)
    List<String> findByDistinctDates();
}
