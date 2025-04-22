package com.etesc.tasksandtasks.api.dto.request;

import jakarta.validation.constraints.Email;

public class LoginRequestDTO {
    @Email(message = "Enseria um email válido")
    private String email;

    public LoginRequestDTO(){

    }

    public LoginRequestDTO(@Email(message = "Enseria um email válido") String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}