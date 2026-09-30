package com.lakshmikandan.primepass.repository;

import com.lakshmikandan.primepass.model.ViewclsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewclsRepository extends JpaRepository<ViewclsModel,Integer> {
}
