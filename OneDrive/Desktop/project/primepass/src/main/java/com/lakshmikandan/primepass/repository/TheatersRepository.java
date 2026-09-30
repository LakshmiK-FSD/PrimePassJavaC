package com.lakshmikandan.primepass.repository;

import com.lakshmikandan.primepass.model.TheatersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatersRepository extends JpaRepository<TheatersModel,Integer> {
}
