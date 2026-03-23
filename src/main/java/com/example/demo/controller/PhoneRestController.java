package com.example.demo.controller;

import com.example.demo.entity.Phone;
import com.example.demo.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/phones")
public class PhoneRestController {

    @Autowired
    private PhoneRepository repository;

    @GetMapping
    public List<Phone> getAllPhones() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phone> getPhoneById(@PathVariable Long id) {
        Phone phone = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Телефон не знайдено з id: " + id));
        return ResponseEntity.ok(phone);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Phone createPhone(@RequestBody Phone phone) {
        return repository.save(phone);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Phone> updatePhone(@PathVariable Long id, @RequestBody Phone phoneDetails) {
        Phone phone = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Телефон не знайдено з id: " + id));

        phone.setBrand(phoneDetails.getBrand());
        phone.setModel(phoneDetails.getModel());
        phone.setPrice(phoneDetails.getPrice());
        phone.setImageUrl(phoneDetails.getImageUrl());

        Phone updatedPhone = repository.save(phone);
        return ResponseEntity.ok(updatedPhone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhone(@PathVariable Long id) {
        Phone phone = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Телефон не знайдено з id: " + id));

        repository.delete(phone);
        return ResponseEntity.noContent().build();
    }
}