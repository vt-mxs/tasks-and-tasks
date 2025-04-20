package com.etesc.tasksandtasks.api.dto.request;
import jakarta.annotation.Nonnull;

public record UserRequestDTO(
		@Nonnull
		String name,
		@Nonnull
		String email) {

}
