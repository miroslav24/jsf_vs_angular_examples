package com.example.backingbean;

import com.example.model.PersonModel;
import com.example.domain.Gender;
import com.example.service.PersonService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@ViewScoped
public class PersonDetailBackingBean implements Serializable {

    @Inject
    private PersonService personService;

    private PersonModel personModel;

    private boolean creatingNewPerson = false;

    @PostConstruct
    public void init() {
        if (FacesContext.getCurrentInstance()
            .getExternalContext()
            .getRequestParameterMap()
            .containsKey("personId")) {
            // load from request parameter -> editing existing person
            personModel = personService.findPerson(Long.parseLong(FacesContext.getCurrentInstance()
                                                                      .getExternalContext()
                                                                      .getRequestParameterMap()
                                                                      .get("personId")));
            creatingNewPerson = false;
        } else {
            // we are creating new person
            personModel = new PersonModel();
            creatingNewPerson = true;
        }
    }

    public PersonModel getPersonModel() {
        return personModel;
    }

    public List<Gender> getGenderOptions() {
        return Arrays.asList(Gender.values());
    }

    public String savePerson() {
        if(creatingNewPerson) {
            personService.addPerson(personModel);
        } else {
            personService.updatePerson(personModel);
        }

        return "personList";
    }
}
