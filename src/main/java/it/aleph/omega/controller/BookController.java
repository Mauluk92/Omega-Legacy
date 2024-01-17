package it.aleph.omega.controller;

import it.aleph.omega.dto.BookDto;
import it.aleph.omega.dto.CreateBookDto;
import it.aleph.omega.service.BookService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/book")
public class BookController {

    @Inject
    private BookService bookService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookById(@PathParam(value="id") Long id){
        return Response.ok().entity(bookService.findBook(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public Response createBook(CreateBookDto bookDto){
        return Response.created(URI.create("/book")).entity(bookService.createBook(bookDto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeBookById(@PathParam(value="id") Long id){
        bookService.removeBook(id);
        return Response.noContent().build();
    }


    @PATCH
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBookStatusById(@PathParam(value="id") Long id, Boolean status){
        return Response.ok().entity(bookService.updateBookStatus(status, id)).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBookById(@PathParam(value="id") Long id, BookDto bookDto){
        return Response.ok().entity(bookService.updateBook(bookDto, id)).build();
    }

    @PATCH
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response associateAuthorListToBook(@PathParam(value="id") Long id, List<Long> authorIdList){
        return Response.ok().entity(bookService.associateAuthorListToBook(authorIdList, id)).build();
    }

    @PATCH
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response associateTagListToBook(@PathParam(value="id") Long id, List<Long> tagIdList){
        return Response.ok().entity(bookService.associateTagListToBook(tagIdList, id)).build();
    }




}
