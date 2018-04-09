package com.example.service;

import com.example.model.PersonModel;
import com.example.domain.Gender;
import com.example.domain.PersonEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class PersonService {

    private Map<Long, PersonEntity> persons = new HashMap<>();

    private static long id = 0;

    private static long nextId() {
        return ++id;
    }

    public PersonService() {
        persons.put(nextId(), new PersonEntity(id, "Ferdo Mravec", Gender.MALE));
        persons.put(nextId(), new PersonEntity(id, "Robin Hood", Gender.MALE));
        persons.put(nextId(), new PersonEntity(id, "Celine Dion", Gender.FEMALE));
        persons.put(nextId(), new PersonEntity(id, "Jozko Mrkvicka", Gender.UNKNOWN));
    }

    public List<PersonModel> getAllPersons() {
        return persons.values().stream().map( p -> toPersonModel(p)).collect(Collectors.toList());
    }

    public void addPerson(PersonModel personModel) {
        long generatedId = nextId();
        personModel.setId(generatedId);
        persons.put(generatedId, toPersonEntity(personModel));
    }

    public void updatePerson(PersonModel personModel) {
        persons.put(personModel.getId(), toPersonEntity(personModel));
    }

    public PersonModel findPerson(long id) {
        return toPersonModel(persons.get(id));
    }

    public void deletePerson(long id) {
        persons.remove(id);
    }

    private PersonModel toPersonModel(PersonEntity personEntity) {
        if(personEntity == null) {
            return null;
        }
        PersonModel personModel = new PersonModel();
        personModel.setId(personEntity.getId());
        personModel.setName(personEntity.getName());
        personModel.setGender(personEntity.getGender());
        return personModel;
    }

    private PersonEntity toPersonEntity(PersonModel personModel) {
        if(personModel == null) {
            return null;
        }
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(personModel.getId());
        personEntity.setName(personModel.getName());
        personEntity.setGender(personModel.getGender());
        return personEntity;
    }
}
