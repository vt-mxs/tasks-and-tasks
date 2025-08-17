package com.etesc.tasksandtasks.api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateTaskRequestDTO(
   Long id,
   @NotBlank(message = "Título da tarefa não pode ficar vazio")
   String title,
   @NotBlank(message = "Descricação da tarefa não pode ficar vazio")
   String description,
   String categoryName,
   String priorityLevel) {
   
}
