package com.lakshmikandan.primepass.repository;

import com.lakshmikandan.primepass.model.ShowsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowsRepository extends JpaRepository<ShowsModel,Integer> {
}
