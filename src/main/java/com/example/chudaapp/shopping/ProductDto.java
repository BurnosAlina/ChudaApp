package com.example.chudaapp.shopping;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductDto {

    private Long id;

    @NotEmpty(message = "To pole nie może być puste!")
    private String name;

    @NotNull(message = "To pole nie może być puste!")
    @Positive(message = "Kwota nie może być ujemna!")
    private BigDecimal amount;

    public ProductDto() {
    }
}
