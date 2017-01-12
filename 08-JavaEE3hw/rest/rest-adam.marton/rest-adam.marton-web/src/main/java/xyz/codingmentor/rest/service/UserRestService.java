package xyz.codingmentor.rest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.rest.dto.UserEntity;
import xyz.codingmentor.rest.exception.IdNotMatchException;

/**
 *
 * @author Ádám
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserRestService {
    private static final Map<String, UserEntity> USERS = new HashMap<>();
      
    // http://localhost:8080/rest-adam.marton-web/rest/users
    @GET
    public List<UserEntity> getAllUsers() {
        return new ArrayList(USERS.values());
    }
    
    // http://localhost:8080/rest-adam.marton-web/rest/users
    // <jsonforRESTapp.json> JSON file for POST committed too (with email, password, address fields)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public UserEntity addUser(UserEntity user) {
        user.setId(UUID.randomUUID().toString());
        USERS.put(user.getId(), user);
        return user;
    }
    
    // http://localhost:8080/rest-adam.marton-web/rest/users/{id}
    // {id} means the generated random UUID
    @GET
    @Path("/{id}")
    public UserEntity getUserById(@PathParam("id") String id) {
        return USERS.get(id);
    }
    
    // http://localhost:8080/rest-adam.marton-web/rest/users/{id}
    // {id} means the generated random UUID
    // the previous json file can be used here, but the url's {id} must be added in the json too
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public UserEntity updateUser(@PathParam("id") String id, UserEntity user) {
        if(id.equals(user.getId())) {
            USERS.replace(id, user);
            return user;
        }
        throw new IdNotMatchException("User IDs not matching");
    }
    
    // http://localhost:8080/rest-adam.marton-web/rest/users/{id}
    // {id} means the generated random UUID
    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") String id) {
        USERS.remove(id);
    }
}
