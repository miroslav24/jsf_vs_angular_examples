package com.example.backingbean;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.UUID;

@Named
@ViewScoped
public class AjaxBackingBean implements Serializable {

    private String randomString;

    @PostConstruct
    public void init() {
        generate();
    }

    public void generate() {
        randomString = UUID.randomUUID().toString().substring(0, 6);
    }

    public String getRandomString() {
        return randomString;
    }
}
