package com.etesc.tasksandtasks.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UserDTO {
    @NotNull(message = "Nome não pode ser vazio")
    private String name;

    @NotNull(message = "Email não pode ser vazio")
    @Email(message = "Ensira uma email válido")
    private String email;

    public UserDTO(){}

    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }   
}