package com.example.jaxb;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Person {

  @NotNull
  @XmlElement
  private Long id;

  @NotNull
  @XmlElement
  private String name;

  @NotNull
  @XmlElement
  private Gender gender;

  public Person() {
  }

  public Person(Long id, String name, Gender gender) {
    this.id = id;
    this.name = name;
    this.gender = gender;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }
}
