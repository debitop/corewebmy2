package com.example.corewebmy2.exceptions;

import static com.example.corewebmy2.config.Constants.USERNAME_EXCEPTION_DESCRIPTION;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(){
        super(USERNAME_EXCEPTION_DESCRIPTION);
    }
    private final long versionUID=-12345678901L;


}
