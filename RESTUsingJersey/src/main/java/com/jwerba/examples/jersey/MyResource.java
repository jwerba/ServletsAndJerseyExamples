package com.jwerba.examples.jersey;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.jwerba.examples.jersey.Model.Person;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("iq/{number}")
    public String getIt(@PathParam("number") String number) {
        return "Got it! " + number;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("find")
    public String findQueryparam(@QueryParam("from") int from, @QueryParam("until") int until) {
        return from + " - " + until;
    }
        
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("person/{number}")
    public Person getPerson(@PathParam("number") String number) {
    	String name = "Jose";
    	Person p = new Person();
    	p.setAge(Integer.parseInt(number));
    	p.setName(name);
    	return p;
    }
    
    
    @POST
    @Path("createUsingForm")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createSomething(MultivaluedMap<String,String> formParams){
    	String name = formParams.getFirst("name");
    	String age = formParams.getFirst("age");
    	Person p = new Person();
    	p.setAge(Integer.parseInt(age));
    	p.setName(name);
    	return Response.ok(p).build();
    }
    
    
    @POST
    @Path("createUsingJson")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createSomething(Person person){
    	//Persist...
    	person.setAge(person.getAge()+1);
    	return Response.ok(person).build();
    }
}
