package com.etesc.tasksandtasks.api.dto.response;

public record TaskResponseDTO(
    Long id,
    String title,
    String description,
    Boolean completed,
	UserResponseDTO user,
	CategoryResponseDTO category,
	PriorityResponseDTO priority) {

}
