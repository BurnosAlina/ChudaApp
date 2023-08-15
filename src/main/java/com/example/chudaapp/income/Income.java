package com.example.chudaapp.income;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private String description;

    private BigDecimal amount;

    public Income() {
    }

    public Income(LocalDate date, String description, BigDecimal amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }
}
