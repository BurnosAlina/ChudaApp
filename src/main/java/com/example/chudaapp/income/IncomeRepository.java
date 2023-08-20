package com.example.chudaapp.income;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface IncomeRepository extends CrudRepository<Income, Long> {

    @Query(value = "select * from income order by date", nativeQuery = true )
    List<Income> findAll();

    @Query(value = "SELECT SUM(amount) FROM income", nativeQuery = true)
    BigDecimal calculateTotalAmount();

    @Query(value = "delete from income", nativeQuery = true)
    @Modifying
    void deleteAll();
}
