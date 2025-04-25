package com.etesc.tasksandtasks.api.dto.request;

import jakarta.validation.constraints.Email;

public record UserLoginRequestDTO(
    @Email(message = "Formato de email inválido")
    String email) {

}
