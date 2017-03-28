package hu.dpc.edu;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Created by vrg on 2016. 11. 09..
 */
@Component
public class JerseyConfig
        extends ResourceConfig {

    public JerseyConfig() {
        register(MessageResource.class);
        register(ConferenceVisitorsResource.class);
        register(EntityNotFoundExceptionMapper.class);
    }
}
