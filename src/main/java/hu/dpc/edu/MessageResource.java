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
    public String getMessage() {
        return "Test";
    }

}
