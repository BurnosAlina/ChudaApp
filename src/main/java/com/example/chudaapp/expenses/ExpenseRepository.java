package com.example.chudaapp.expenses;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    @Query(value = "select * from expense order by date", nativeQuery = true )
    List<Expense> findAll();

    @Query(value = "SELECT SUM(amount) FROM expense", nativeQuery = true)
    BigDecimal calculateTotalAmount();

    @Query(value = "delete from expense", nativeQuery = true)
    @Modifying
    void deleteAll();

}
