package com.example.restwebServices.restfulwebservices.user;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=org.springframework.http.HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
