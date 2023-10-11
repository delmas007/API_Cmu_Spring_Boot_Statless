package com.example.cmuspring.Exception;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException{

    @Getter
    private ErrorCodes errorCodes;
    @Getter
    private String msg;

    public EntityNotFoundException(String message){
        super(message);
    }
    public EntityNotFoundException(String message,Throwable cause){
        super(message,cause);
    }
    public EntityNotFoundException(String message,ErrorCodes errorCodes){
        super(message);
        this.errorCodes = errorCodes;
    }
    public EntityNotFoundException(String message,ErrorCodes errorCodes,String msg){
        super(message);
        this.errorCodes = errorCodes;
        this.msg = msg;
    }
    public EntityNotFoundException(String message,Throwable cause,ErrorCodes errorCodes){
        super(message,cause);
        this.errorCodes = errorCodes;
    }
}
