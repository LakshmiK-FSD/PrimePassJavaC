package com.lakshmikandan.primepass.repository;

import com.lakshmikandan.primepass.model.MovieDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDetailsRepository extends JpaRepository<MovieDetailsModel,Integer> {
}
