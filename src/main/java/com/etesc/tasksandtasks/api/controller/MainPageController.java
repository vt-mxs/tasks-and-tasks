package com.etesc.tasksandtasks.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.etesc.tasksandtasks.api.dto.UserForm;
import com.etesc.tasksandtasks.api.dto.request.UserRequestDTO;
import com.etesc.tasksandtasks.api.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class MainPageController {
    @Autowired
    private UserService service;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("user", new UserForm());
        return "index";
    }
    
    @PostMapping("/create/user")
    public String postMethodName(@ModelAttribute @Valid UserForm form) {
        UserRequestDTO dto = new UserRequestDTO(form.getName(), form.getEmail());
        service.createUser(dto);
        return "redirect:/";
    }
    
}