package com.lakshmikandan.primepass.repository;
import com.lakshmikandan.primepass.model.DateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DateRepository extends JpaRepository<DateModel,Integer> {
}
