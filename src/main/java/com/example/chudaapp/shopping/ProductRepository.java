package com.example.chudaapp.shopping;

import com.example.chudaapp.income.Income;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "select * from product", nativeQuery = true )
    List<Product> findAll();
}
