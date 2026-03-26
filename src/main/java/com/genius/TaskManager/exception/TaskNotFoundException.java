package com.genius.TaskManager.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(String msg){
        super(msg);
    }
}
