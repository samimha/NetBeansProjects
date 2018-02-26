/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import model.Contact;

/**
 * REST Web Service
 *
 * @author Sami
 */
@Path("generic")
public class GenericResource {
    
    @EJB
    private SessionBean sb;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of controller.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> getAllContacts() {
        return sb.selectAll();
    }
    
    
    @GET
    @Path("byid")
    @Produces(MediaType.APPLICATION_JSON)
    public Contact getContactById(@QueryParam("id") int id){
        return sb.selectById(id);
    }
    
    @POST
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    public void insert(Contact c){
        sb.insert(c);
    }
    
    @PUT
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    public void update(Contact c){
        sb.update(c);
    }
    
    @DELETE
    @Path("del")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@QueryParam("id")int id){
        sb.delete(id);
    }
    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
    
    
}
