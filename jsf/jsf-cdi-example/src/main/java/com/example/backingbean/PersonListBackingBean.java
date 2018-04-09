package com.example.backingbean;

import com.example.domain.Gender;
import com.example.model.PersonModel;
import com.example.service.PersonService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Named
@ViewScoped
public class PersonListBackingBean implements Serializable {

    @Inject
    private PersonService personService;

    private List<PersonModel> persons;

    public List<PersonModel> getAllPersons() {
        if(persons == null) {
            persons = personService.getAllPersons();
        }
        return persons;
    }

    /**
     * ViewScoped will not survive redirect so we delete data and redirect will create new instance of PersonListBackingBean
     * @param id
     * @return
     */
    public String deletePerson(long id) {
        personService.deletePerson(id);
        return "personList";
    }


    public void addTestPerson() {
        PersonModel personModel = new PersonModel();
        personModel.setGender(Gender.UNKNOWN);
        personModel.setName(UUID.randomUUID().toString().substring(0, 6));
        personService.addPerson(personModel);

        // this is ajax request so there is no redirect -> we need to update our data list
        persons = personService.getAllPersons();
    }
}
