package com.etesc.tasksandtasks.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.etesc.tasksandtasks.api.dto.UserDTO;
import com.etesc.tasksandtasks.api.dto.request.LoginRequestDTO;
import com.etesc.tasksandtasks.api.dto.response.UserResponseDTO;
import com.etesc.tasksandtasks.api.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class AuthController {
    @Autowired
    private UserService service;
    
    @PostMapping("/register")
    public String handleUserRegistration(@ModelAttribute @Valid UserDTO form, HttpSession session) {
        UserResponseDTO user = service.createUser(form);
        session.setAttribute("user", user);
        return "redirect:/work-area";
    }

    @PostMapping("/login")
    public String handleUserLogin(@ModelAttribute @Valid LoginRequestDTO form, HttpSession session) {
        UserResponseDTO user = service.loginUser(form.getEmail());
        session.setAttribute("user", user);
        return "redirect:/work-area";
    }
}