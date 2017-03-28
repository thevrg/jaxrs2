package hu.dpc.edu;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by vrg on 2017. 03. 27..
 */
@Provider
public class EntityNotFoundExceptionMapper implements ExceptionMapper<EntityNotFoundException> {
    @Override
    public Response toResponse(EntityNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new Message(404, exception.getMessage())).build();
    }
}
