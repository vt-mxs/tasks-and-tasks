package com.etesc.tasksandtasks.api.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.etesc.tasksandtasks.api.dto.UserDTO;
import com.etesc.tasksandtasks.api.dto.request.LoginRequestDTO;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthPagesRouteController {
    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("user", new UserDTO());
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new LoginRequestDTO());
        return "login-page";
    }

    @GetMapping("/work-area")
    public String showWorkAreaPage(HttpSession session) {
        return "work-area";
    }
    
}