package com.tomasz.controller;

import com.tomasz.model.Customer;
import com.tomasz.repo.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerController(CustomerRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users")
    public List<Customer> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer user){
        String hashPwd = passwordEncoder.encode(user.getPwd());
        user.setPwd(hashPwd);
        user.setDateRegistration(LocalDateTime.now());
        Customer savedUser = userRepository.save(user);
        return ResponseEntity.ok().build();
    }



}
