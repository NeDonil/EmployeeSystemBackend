package com.vstu.employeesystembackend.exceptions;

public class VacationCannotCreateException extends RuntimeException{
    public VacationCannotCreateException(String message){
        super(message);
    }
}
