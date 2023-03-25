package com.example.ecommerce_app.security;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecommerce_app.user.ApplicationUser;

@Controller
@Validated
@RequestMapping("/api/login")
public class LoginController {
    
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public ApplicationUser login(@RequestBody ApplicationUser user) {
        return loginService.login(user);
    }

}
