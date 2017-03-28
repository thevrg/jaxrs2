package hu.dpc.edu;

import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;

/**
 * Created by vrg on 2016. 11. 09..
 */
@RestResource
@Path("message")
public class MessageResource {

    private String message;

    @GET
    @Produces("text/plain")
    public String getMessage() {
        return message;
    }

    @PUT
    @Consumes("text/plain")
    public void setMessage(String message) {
        this.message = message;
    }

}
