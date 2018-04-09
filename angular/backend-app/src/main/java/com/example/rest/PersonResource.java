package com.example.rest;

import com.example.jaxb.AddPersonRequest;
import com.example.jaxb.Person;
import com.example.service.PersonService;
import com.example.utils.RestUtils;

import org.slf4j.Logger;

import java.io.IOException;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static com.example.utils.RestUtils.MEDIA_TYPE_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

/**
 * person reource api is available at http://localhost:8080/backend/api/person-resource/persons
 */

@Path("person-resource")
@Produces(MEDIA_TYPE_JSON)
@Consumes(APPLICATION_JSON)
public class PersonResource {

  @Inject
  private Logger logger;

  @Inject
  private PersonService personService;

  @GET
  @Path("/persons")
  public Response getAllPersons() {
    return RestUtils.getNoCacheResponseBuilder(Response.Status.OK)
        .entity(personService.getAllPersons())
        .build();
  }

  @GET
  @Path("/persons/{personId}")
  public Response getPerson(@PathParam("personId") long personId) {
    Person person = personService.getPerson(personId);
    if(person != null) {
      return RestUtils.getNoCacheResponseBuilder(Response.Status.OK)
          .entity(person)
          .build();
    }
    return RestUtils.getNoCacheResponseBuilder(Response.Status.NOT_FOUND).build();
  }

  @DELETE
  @Path("/delete/{personId}")
  public Response deletePerson(@PathParam("personId") long personId) {
    personService.deletePerson(personId);

    return RestUtils.getNoCacheResponseBuilder(Response.Status.OK)
        .entity(personService.getAllPersons())
        .build();
  }

  @POST
  @Path("/add")
  public Response addPerson(@Valid AddPersonRequest addPersonRequest) throws IOException {

    personService.addPerson(addPersonRequest);

    return RestUtils.getNoCacheResponseBuilder(Response.Status.OK)
        .entity(personService.getAllPersons())
        .build();
  }

  @POST
  @Path("/update")
  public Response updateSkill(@Valid Person person) throws IOException {

    personService.updatePerson(person);

    return RestUtils.getNoCacheResponseBuilder(Response.Status.OK)
        .entity(personService.getAllPersons())
        .build();
  }
}
