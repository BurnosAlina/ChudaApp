package com.example.chudaapp.controllers;

import com.example.chudaapp.user.UserInfoService;
import com.example.chudaapp.user.UserRegistrationDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private UserInfoService userInfoService;

    public LoginController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("/login")
    String loginForm() {
        return "login-form";
    }

    @GetMapping("/register")
    String register(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "register";
    }

    @PostMapping("/register")
    String registerUser(@RequestParam String passwordConfirmation,
                        @Valid @ModelAttribute("user") UserRegistrationDto dto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", dto);
            return "register";
        }
        if (!userInfoService.isPasswordTheSame(passwordConfirmation, dto)) {
            model.addAttribute("notTheSamePassword", "Hasło musi być takie same!");
            return "register";
        }
        userInfoService.register(dto);
        model.addAttribute("confirmation", "Konto zarejestrowane pomyślnie! Zaloguj się.");
        return "login-form";
    }
}
