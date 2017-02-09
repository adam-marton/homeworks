package xyz.codingmentor.movie.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.movie.api.CRUDService;
import xyz.codingmentor.movie.api.CRUDServiceQualifier;
import xyz.codingmentor.movie.api.Entity;
import xyz.codingmentor.movie.entity.Category;

/**
 *
 * @author Ádám
 */
@Path("/category")
public class CategoryCRUDResource {

    private CRUDService<Category> categoryService;

    public CategoryCRUDResource() {
        //default constructor
    }

    @Inject
    public CategoryCRUDResource(@CRUDServiceQualifier(Entity.CATEGORY) CRUDService<Category> categoryService) {
        this.categoryService = categoryService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCategory(Category category) {
        categoryService.createEntity(category);
        return Response.ok(category).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategoryById(@PathParam("id") Long id) {
        Category category = categoryService.getEntityById(id);
        if(null != category) {
            return Response.ok(category).build();
        }
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCategory(@PathParam("id") Long id, Category category) {
        if(id.equals(category.getId())) {
            categoryService.updateEntity(category);
            return Response.ok(category).build();
        }
        return Response.serverError().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCategory(@PathParam("id") Long id) {
        if(null != categoryService.getEntityById(id)) {
            categoryService.removeEntity(id);
            return Response.ok().build();
        }
        return Response.noContent().build();
    }
}
