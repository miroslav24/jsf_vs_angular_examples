package com.example.service;

import com.example.jaxb.AddPersonRequest;
import com.example.jaxb.Gender;
import com.example.jaxb.Person;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

@ApplicationScoped
public class PersonService {

  @Inject
  private Logger logger;

  private Map<Long, Person> persons = new HashMap<>();

  private static long id = 0;

  public PersonService() {
    persons.put(nextId(), new Person(id, "Jozko", Gender.MALE));
    persons.put(nextId(), new Person(id, "Herkules", Gender.UNKNOWN));
    persons.put(nextId(), new Person(id, "Celine Dion", Gender.FEMALE));
    persons.put(nextId(), new Person(id, "Ferko Mrkvicka", Gender.MALE));
  }

  private long nextId() {
    return ++id;
  }

  public Collection<Person> getAllPersons() {
    return persons.values();
  }

  public void addPerson(@NotNull AddPersonRequest addPersonRequest) {
    Person person = new Person(nextId(), addPersonRequest.getName(), addPersonRequest.getGender());
    persons.put(id, person);
  }

  public void deletePerson(long id) {
    persons.remove(id);
  }

  public void updatePerson(@NotNull Person person) {
    persons.put(person.getId(), person);
  }

  public Person getPerson(long id) {
    return persons.get(id);
  }
}
