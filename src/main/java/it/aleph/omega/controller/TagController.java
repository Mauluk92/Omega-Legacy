package it.aleph.omega.controller;

import it.aleph.omega.dto.TagDto;
import it.aleph.omega.service.TagService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;

@Path("/tag")
public class TagController {
    private final TagService tagService;

    @Inject
    public TagController(TagService tagService){
        this.tagService = tagService;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findTagById(@PathParam("id") Long id){
        return Response.ok().entity(tagService.findTagById(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTag(TagDto tagDto){
        return Response.created(URI.create("/tag")).entity(tagService.createTag(tagDto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeTagById(@PathParam("id") Long id){
        tagService.deleteTag(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTagById(@PathParam("id") Long id, TagDto tagDto){
        return Response.ok().entity(tagService.updateTag(tagDto, id)).build();
    }
}
