package com.example.fooddelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/login")
    @ResponseBody
    public String login() {
        return "Users/navneetverma/food-delivery/src/main/resources/static/login.html";
    }
}
