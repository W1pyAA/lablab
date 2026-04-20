package com.example.demo.controller;

import com.example.demo.entity.Phone; // Твій клас Phone
import com.example.demo.repository.PhoneRepository; // Твій репозиторій
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/custom/phones") // Використовуємо інший шлях, щоб не конфліктувати з налаштуваннями з 7-ї лаби
@CrossOrigin("http://localhost:5173")
public class PhoneController {

    private final PhoneRepository phoneRepository;

    public PhoneController(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @GetMapping
    public List<Phone> getAllPhones() {
        log.info("Отримання списку мобільних телефонів"); // Виведення в лог
        return phoneRepository.findAll();
    }

    @PostMapping
    public Phone createPhone(@RequestBody Phone phone) {
        log.info("Додавання нового телефону: {} {}", phone.getBrand(), phone.getModel());
        return phoneRepository.save(phone);
    }
}