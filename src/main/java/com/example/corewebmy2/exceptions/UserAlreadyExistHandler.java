package com.example.corewebmy2.exceptions;


import com.example.corewebmy2.config.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class UserAlreadyExistHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserAlreadyExistException.class)
    UserAlreadyExistResponse userAlreadyExistHandler(Exception ex) {
        return UserAlreadyExistResponse.of()
                .error(Constants.USERNAME_EXCEPTION_CODE)
                .errorDescription(ex.getMessage())
                .httpStatus(HttpStatus.CONFLICT)
                .create();
    }

}
