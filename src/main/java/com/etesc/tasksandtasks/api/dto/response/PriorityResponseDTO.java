package com.etesc.tasksandtasks.api.dto.response;

import jakarta.validation.constraints.NotBlank;

public record PriorityResponseDTO(@NotBlank String level) {

}
