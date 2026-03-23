package com.example.demo.controller;

import com.example.demo.entity.Phone;
import com.example.demo.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/phones")
public class PhoneWebController {

    @Autowired
    private PhoneRepository repository;

    // Відображення списку всіх телефонів
    @GetMapping
    public String listPhones(Model model) {
        model.addAttribute("phones", repository.findAll());
        return "phones-list";
    }

    // Відображення форми для створення нового телефону
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("phone", new Phone());
        return "phone-form";
    }

    // Збереження нового або відредагованого телефону
    @PostMapping("/save")
    public String savePhone(@ModelAttribute("phone") Phone phone) {
        repository.save(phone);
        return "redirect:/phones";
    }

    // Відображення форми для редагування
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Phone phone = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Невірний ID телефону: " + id));
        model.addAttribute("phone", phone);
        return "phone-form";
    }

    // Видалення телефону
    @GetMapping("/{id}/delete")
    public String deletePhone(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/phones";
    }
}