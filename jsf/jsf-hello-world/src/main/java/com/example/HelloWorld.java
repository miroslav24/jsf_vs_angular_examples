package com.example;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class HelloWorld implements Serializable {

    private String message;

    public HelloWorld() {
        this.message = "Hello world!";
    }

    public String getMessage() {
        return message;
    }
}
