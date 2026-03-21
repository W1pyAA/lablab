package com.example.demo.controller;

import com.example.demo.entity.Phone;
import com.example.demo.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/phones")
@CrossOrigin(origins = "http://localhost:5173")
public class PhoneController {

    @Autowired
    private PhoneRepository repository;

    @GetMapping
    public List<Phone> getAllPhones() {
        return repository.findAll();
    }
}