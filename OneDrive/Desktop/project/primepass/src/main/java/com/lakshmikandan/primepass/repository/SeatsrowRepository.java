package com.lakshmikandan.primepass.repository;

import com.lakshmikandan.primepass.model.SeatsrowModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatsrowRepository extends JpaRepository<SeatsrowModel,Integer> {
}
