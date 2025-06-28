package com.etesc.tasksandtasks.api.exception;

public class TaskNotFoundException extends RuntimeException {
   public TaskNotFoundException() {
      super();
   }

   
   public TaskNotFoundException(String message) {
      super(message);
   }

   
   public TaskNotFoundException(String message, Throwable cause) {
      super(message, cause);
   }
}
