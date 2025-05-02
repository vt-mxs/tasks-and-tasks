package com.etesc.tasksandtasks.api.dto.request;

import jakarta.validation.constraints.Email;

public record UserEmailRequestDTO(@Email(message = "Ensira um email válido") String email) {

}
