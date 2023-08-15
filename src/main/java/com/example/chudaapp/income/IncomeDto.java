package com.example.chudaapp.income;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
public class IncomeDto {

    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Wybierz datę!")
    private LocalDate date;

    @NotEmpty(message = "Opis nie może być pusty!")
    private String description;

    @NotNull(message = "To pole nie może być puste!")
    @Positive(message = "Kwota nie może być ujemna!")
    private BigDecimal amount;

    public IncomeDto() {
    }
}
