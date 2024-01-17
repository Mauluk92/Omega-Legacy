package it.aleph.omega.controller;

import it.aleph.omega.dto.AuthorDto;
import it.aleph.omega.service.AuthorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;

@Path("/author")
public class AuthorController {

    @Inject
    private AuthorService authorService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthorById(@PathParam("id") Long id){
        return Response.ok().entity(authorService.findAuthorById(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAuthor(AuthorDto authorDto){
        return Response.created(URI.create("/author")).entity(authorService.createAuthor(authorDto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeAuthorById(@PathParam("id") Long id){
        authorService.deleteAuthor(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAuthorById(@PathParam("id") Long id, AuthorDto authorDto){
        return Response.ok().entity(authorDto).build();
    }



}
