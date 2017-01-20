package xyz.codingmentor.webshop.exception;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import xyz.codingmentor.webshop.dto.ResultDTO;
import xyz.codingmentor.webshop.dto.ResultType;

/**
 *
 * @author Ádám
 */ 
@Provider
public class AuthenticationFailureExceptionMapper implements ExceptionMapper<AuthenticationFailureException> {
    private static final Logger LOGGER = Logger.getLogger(AuthenticationFailureExceptionMapper.class.getName());

    @Override
    public Response toResponse(AuthenticationFailureException throwable) {
        LOGGER.log(Level.SEVERE, "Authentication Exception", throwable);
        return Response.status(Response.Status.UNAUTHORIZED).entity(new ResultDTO(ResultType.ERROR, 
                throwable.getMessage())).type(MediaType.APPLICATION_JSON).build();
    }
}   
