package com.smart.controller;

import com.smart.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("")
public class LoginController {

    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public LoginController(BCryptPasswordEncoder passwordEncoder, JwtUtil jwtUtil){
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/public")
    public String home(){
        return "Welcome";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> user){
        String username = user.get("username");
        String password = user.get("password");

        if("admin".equals(username) && passwordEncoder.matches(password, passwordEncoder.encode(password))){
            String token = jwtUtil.generateToken(username);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return response;
        } else{
            throw new RuntimeException("Invalid username or password");
        }
    }
}