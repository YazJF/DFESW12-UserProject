package com.example.DFESW12UserProject.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User does not exist")
public class UserNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1;

    public UserNotFoundException() {
        super();
    }

}

