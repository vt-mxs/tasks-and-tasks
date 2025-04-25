package com.etesc.tasksandtasks.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
    @NotBlank(message = "Nome não pode ficar vázio")
    String name,
    @Email(message = "Formato de email inválido")
    String email) {

}
