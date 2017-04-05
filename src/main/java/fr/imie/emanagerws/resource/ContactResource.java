package fr.imie.emanagerws.resource;

import fr.imie.emanagerws.entity.Contact;
import fr.imie.emanagerws.service.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/contacts")
@Produces({MediaType.APPLICATION_JSON})

public class ContactResource {

    private final Service service;

    public ContactResource(Service service){
        this.service = service;
    }

    @GET
    public List<Contact> getContacts (){
        return this.service.getContacts();
    }

    @GET
    @Path("/{id}")
    public Contact getContactByIdWithPathParam(@PathParam("id") final long id){
    	return this.service.findContactById(id);
    }

    @POST
    public Contact create (Contact contact) {
        return this.service.addContact(contact);
    }

//    @PUT
//    @Path("{id}")
//    public Response update (Person person) {
//
//        return Response.ok("put--").build();
//
//    }



    @DELETE
    public void delete (Contact contact) {
        this.service.deleteContact(contact);

    }
}
