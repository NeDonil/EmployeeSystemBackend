package com.vstu.employeesystembackend.exceptions;

public class EmployeeCannotCreateException extends RuntimeException{
    public EmployeeCannotCreateException(String message){
        super(message);
    }
}
