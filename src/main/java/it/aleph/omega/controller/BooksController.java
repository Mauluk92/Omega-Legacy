package it.aleph.omega.controller;

import it.aleph.omega.service.BookService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/books")
public class BooksController {
    @Inject
    private BookService bookService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooksFilteredSearch(@QueryParam("authorId") Long authorId,
                                           @QueryParam("tagIdList") List<Long> tagIdList,
                                           @QueryParam("title") String title,
                                           @QueryParam("pageNumber") @DefaultValue("0") Integer pageNumber,
                                           @QueryParam("pageSize") @DefaultValue("10") Integer pageSize
                                           ){
        return Response.ok().entity(bookService.findBooksFiltered(pageNumber, pageSize, authorId, tagIdList, title)).build();

    }
}
