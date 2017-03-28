package hu.dpc.edu;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by vrg on 2017. 03. 27..
 */
@RestResource
@Path("visitors")
public class ConferenceVisitorsResource {

    private AtomicLong idSequence = new AtomicLong();
    private Map<Long,ConferenceVisitor> visitorMap = new HashMap<>();

    @GET
    @Path("{visitorID: \\d+}")
    @Produces({"application/json", "application/xml"})
    public ConferenceVisitor findById(@PathParam("visitorID") long visitorId) {
        final ConferenceVisitor conferenceVisitor = visitorMap.get(visitorId);
        if (conferenceVisitor == null) {
            throw new EntityNotFoundException("Visitor not found with id " + visitorId);
        } else {
            return conferenceVisitor;
        }
    }

    @PUT
    @Path("{visitorID: \\d+}")
    @Consumes({"application/json", "application/xml"})
    @Produces({"application/json", "application/xml"})
    public Message replaceById(@PathParam("visitorID") long visitorId, ConferenceVisitor updatedVisitor) {
        updatedVisitor.setId(visitorId);
        final ConferenceVisitor persistedVisitor = visitorMap.get(visitorId);
        if (persistedVisitor == null) {
            throw new EntityNotFoundException("Visitor not found with id " + visitorId);
        }
        visitorMap.put(visitorId, updatedVisitor);
        return new Message(200, "ConferenceVisitor was successfully updated");
    }

    @GET
    @Path("test")
    @Produces({"application/json", "application/xml"})
    public ConferenceVisitor test() {
        return new ConferenceVisitor(123L, "First", "Last");
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response addVisitor(ConferenceVisitor newVisitor, @Context UriInfo uriInfo) {
        final long newId = idSequence.incrementAndGet();
        newVisitor.setId(newId);
        visitorMap.put(newId, newVisitor);

        final URI newVisitorURI = uriInfo.getAbsolutePathBuilder()
                .path(ConferenceVisitorsResource.class, "findById")
                .build(newId);

        return Response.created(newVisitorURI)
                .build();
    }

}
