package com.biss.demo.Budget2.Ex;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Person not found")

public class PersonNotFoundEx extends Exception {

    public PersonNotFoundEx(String errorMessage){
        super(errorMessage);
    }
}
