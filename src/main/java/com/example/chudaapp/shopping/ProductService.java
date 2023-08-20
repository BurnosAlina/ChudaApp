package com.example.chudaapp.shopping;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDto> findAll() {
        List<Product> allProducts = productRepository.findAll();
        List<ProductDto> productsDto = new ArrayList<>();
        for (Product product : allProducts) {
            ProductDto productDto = productMapper.convertToDto(product);
            productsDto.add(productDto);
        }
        return productsDto;
    }

    @Transactional
    public void save(ProductDto productDto) {
        Product product = productMapper.convertFromDto(productDto);
        productRepository.save(product);
    }
}
