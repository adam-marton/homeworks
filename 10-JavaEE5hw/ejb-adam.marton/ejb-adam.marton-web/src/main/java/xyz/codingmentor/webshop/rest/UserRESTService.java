package xyz.codingmentor.webshop.rest;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.webshop.database.UserDB;
import xyz.codingmentor.webshop.dto.ResultDTO;
import xyz.codingmentor.webshop.dto.ResultType;
import xyz.codingmentor.webshop.entity.UserEntity;
import xyz.codingmentor.webshop.exception.AuthenticationFailureException;

/**
 *
 * @author Ádám
 */
@Path("/users")
@SessionScoped
@Produces(MediaType.APPLICATION_JSON)
public class UserRESTService implements Serializable {
    public static final String USER_KEY = "user";
    @Inject
    private transient UserDB userDB;
    
    /**
     *
     * http://localhost:8080/ejb-adam.marton-web/webshop/users/login
     */    
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultDTO login(@Context HttpServletRequest request, UserEntity user) throws AuthenticationFailureException {
        if(!userDB.authenticate(user.getUsername(), user.getPassword())) {
            throw new AuthenticationFailureException("Invalid username or password!");
        }
        UserEntity loggedInUser = userDB.getUser(user.getUsername());
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(2000);
        session.setAttribute(USER_KEY, loggedInUser);
        return new ResultDTO(ResultType.SUCCESS, loggedInUser);
    }
    
    /**
     *
     * http://localhost:8080/ejb-adam.marton-web/webshop/users/logout
     */ 
    @POST
    @Path("/logout")
    public ResultDTO logout(@Context HttpServletRequest request) {
        UserEntity user = (UserEntity) request.getSession().getAttribute(USER_KEY);
        request.getSession().invalidate();
        return new ResultDTO(ResultType.SUCCESS, user);
    }
    
    /**
     *
     * http://localhost:8080/ejb-adam.marton-web/webshop/users/{username}
     */ 
    @GET
    @Path("/{username}")
    public UserEntity getUserByUsername(@PathParam ("username") String username) {
        return userDB.getUser(username);
    }
    
    /**
     *
     * http://localhost:8080/ejb-adam.marton-web/webshop/users
     */ 
    @GET
    public List<UserEntity> getAllUsers() {
        return userDB.getAllUsers();
    }
    
    /**
     *
     * http://localhost:8080/ejb-adam.marton-web/webshop/users
     */ 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultDTO addUser(@Context HttpServletRequest request, UserEntity user) {
        checkCredentials(request);
        checkAdmin(request);
        userDB.addUser(user);
        return new ResultDTO(ResultType.SUCCESS, user);
    }
    
    /**
     *
     * http://localhost:8080/ejb-adam.marton-web/webshop/users
     */ 
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultDTO deleteUser(@Context HttpServletRequest request, UserEntity user) {
        checkCredentials(request);
        checkAdmin(request);
        userDB.deleteUser(user);
        return new ResultDTO(ResultType.SUCCESS, user);
    }
    
    public void checkCredentials(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute(USER_KEY) == null){
            throw new IllegalStateException("You are not logged in!");
        }
    }
    
    public void checkAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity) session.getAttribute(USER_KEY);
        if(!user.isAdmin()) {
            throw new IllegalStateException("You are not an admin!");
        }
    }
}