package com.example.chudaapp.controllers;

import com.example.chudaapp.user.UserInfoDto;
import com.example.chudaapp.user.UserInfoService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.NoSuchElementException;

@Controller
public class HomeController {

    private UserInfoService userInfoService;


    public HomeController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @RequestMapping("/")
    String home(Model model) {
        try {
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            UserInfoDto user = userInfoService.findByEmail(userName);
            model.addAttribute("user", user);
        } catch (NoSuchElementException e) {
            //ignore
        }
        return "index";
    }
}
