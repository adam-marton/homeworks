package xyz.codingmentor.rest.exception;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Ádám
 */
@Provider
public class IdNotMatchExceptionMapper implements ExceptionMapper<IdNotMatchException> {
    private static final Logger LOGGER = Logger.getLogger(IdNotMatchExceptionMapper.class.getSimpleName());

    @Override
    public Response toResponse(IdNotMatchException exception) {
        LOGGER.log(Level.SEVERE, "Exception on web service", exception);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorDTO(exception.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
