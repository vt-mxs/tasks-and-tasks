package com.etesc.tasksandtasks.api.dto.response;

import jakarta.validation.constraints.NotBlank;

public record CategoryResponseDTO(@NotBlank String name) {

}
