package com.demo.Budget2.Ex;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(Long id){
        super("Person not found with id " + id);
    }
}
