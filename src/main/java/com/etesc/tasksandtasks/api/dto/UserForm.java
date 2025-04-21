package com.etesc.tasksandtasks.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UserForm {
    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    public UserForm(){}

    public UserForm(String name, String email) {
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