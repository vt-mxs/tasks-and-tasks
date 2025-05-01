package com.etesc.tasksandtasks.api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record TaskRequestDTO(
    @NotBlank
    String title,
    @NotBlank
    String description,
	String userEmail,
	String categoryName,
	String priorityLevel) {

}
