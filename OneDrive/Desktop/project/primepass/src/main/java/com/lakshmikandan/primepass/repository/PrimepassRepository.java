package com.lakshmikandan.primepass.repository;

import com.lakshmikandan.primepass.model.PrimepassModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimepassRepository extends JpaRepository<PrimepassModel,Integer> {
}
