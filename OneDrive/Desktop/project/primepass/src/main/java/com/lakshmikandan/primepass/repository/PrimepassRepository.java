package com.lakshmikandan.primepass.repository;

import com.lakshmikandan.primepass.model.PrimepassModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrimepassRepository extends JpaRepository<PrimepassModel,Integer> {

   @Query(value = "select * from primepass_model where movename like CONCAT('%',:search,'%') order by movename ASC ", nativeQuery = true)
    List<PrimepassModel> findBySearch(@Param("search") String search);
}
