package com.lakshmikandan.primepass.controller;

import com.lakshmikandan.primepass.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {
    @Autowired
    public AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String,String> user){
      return authService.register(user);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> user){
        return authService.login(user);
    }

}
