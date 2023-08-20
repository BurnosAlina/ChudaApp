package com.example.chudaapp.shopping;

import com.example.chudaapp.income.Income;
import com.example.chudaapp.income.IncomeDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto convertToDto (Product product){
        return new ProductDto(product.getId(), product.getName(), product.getAmount());
    }

    public Product convertFromDto (ProductDto dto){
        return new Product(dto.getName(), dto.getAmount());
    }
}
