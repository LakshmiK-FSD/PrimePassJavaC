package com.lakshmikandan.primepass.repository;

import com.lakshmikandan.primepass.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel,Integer> {
  public Optional<UsersModel> findByUserName(String userName);
    public Optional<UsersModel> findByEmail(String email);
}
