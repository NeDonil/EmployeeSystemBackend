package com.vstu.employeesystembackend.exceptions;

public class TaskCannotCreateException extends RuntimeException{
    public TaskCannotCreateException(String message){
        super(message);
    }
}
