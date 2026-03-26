package com.genius.TaskManager.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<String> taskNotFoundException(TaskNotFoundException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
