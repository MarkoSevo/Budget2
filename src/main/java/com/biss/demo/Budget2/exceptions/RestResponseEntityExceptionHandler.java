package com.biss.demo.Budget2.exceptions;

import com.biss.demo.Budget2.controller.PersonController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice (basePackageClasses = PersonController.class)

public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

@ExceptionHandler(PersonNotFoundException.class)
@ResponseBody
    public ResponseEntity<Object> handleIllegalArgumentException(
            Exception e){
        return new ResponseEntity<>("pogresan unos",HttpStatus.NOT_FOUND);
    }
}
