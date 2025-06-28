package com.etesc.tasksandtasks.api.dto.request;

import java.time.LocalDateTime;

public record CompleteTaskRequestDTO(
   LocalDateTime dueDate,
   boolean completed) {

}
