package com.example.chudaapp.controllers;

import com.example.chudaapp.income.IncomeDto;
import com.example.chudaapp.shopping.ProductDto;
import com.example.chudaapp.shopping.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/shoppingList")
    String shoppingList(Model model) {
        List<ProductDto> productsDto = productService.findAll();
        model.addAttribute("product", new ProductDto());
        model.addAttribute("products", productsDto);
        return "shoppingList";
    }

    @PostMapping("/addProduct")
    String addProduct (@Valid @ModelAttribute("product") ProductDto productDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("product", productDto);
            List<ProductDto> productsDto = productService.findAll();
            model.addAttribute("products", productsDto);
            return "shoppingList";
        }
        productService.save(productDto);
        List<ProductDto> productsDto = productService.findAll();
        model.addAttribute("products", productsDto);
        return "shoppingList";
    }
}
