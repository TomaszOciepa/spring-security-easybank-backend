package com.tomasz.controller;

import com.tomasz.model.Customer;
import com.tomasz.repo.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository userRepository;

    public CustomerController(CustomerRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<Customer> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer user){
        Customer savedUser = userRepository.save(user);
        return ResponseEntity.ok().build();
    }



}
