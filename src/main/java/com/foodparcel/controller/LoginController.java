package com.foodparcel.controller;

import com.foodparcel.security.Login;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @GetMapping(produces = "application/json")
    @RequestMapping("/validateLogin")
    public Login login(){
        return new Login("Logged in...");
    }
}
