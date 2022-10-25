package io.quarkus.workshop.superheroes.villain;

import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestPath;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/api/villains")
public class VillainResource {

    private final Logger logger;
    private final VillainService service;

    public VillainResource(Logger logger, VillainService service) {
        this.logger = logger;
        this.service = service;
    }

    @GET
    @Path("/random")
    public Response getRandomVillain() {
        var villain = service.findRandomVillain();
        logger.debug("Found random villain: " + villain);
        return Response.ok(villain).build();
    }

    @GET
    public Response getAllVillains() {
        var villains = service.findAllVillains();
        logger.debug("Total number of villains: " + villains);
        return Response.ok(villains).build();
    }

    @GET
    @Path("/{id}")
    public Response getVillain(@RestPath Long id) {
        var villain = service.findVillainById(id);
        if (villain == null) {
            logger.debug("No villain found with id: " + id);
            return Response.noContent().build();
        }
        logger.debug("Found villain: " + villain);
        return Response.ok(villain).build();
    }

    @POST
    public Response createVillain(@Valid Villain villain, @Context UriInfo uriInfo) {
        var created = service.persistVillain(villain);
        var uriBuilder = uriInfo.getAbsolutePathBuilder().path(Long.toString(villain.id));
        URI uri = uriBuilder.build();
        logger.debug("new villain created with URI: " + uri.toString());
        return Response.created(uri).build();
    }

    @PUT
    public Response updateVillain(@Valid Villain villain) {
        var updated = service.updateVillain(villain);
        logger.debug("villain updated: " + villain);
        return Response.ok(villain).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteVillain(@RestPath Long id) {
        service.deleteVillain(id);
        logger.debug("villain deleted with id: " + id);
        return Response.noContent().build();
    }


    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello Villain Resource";
    }
}