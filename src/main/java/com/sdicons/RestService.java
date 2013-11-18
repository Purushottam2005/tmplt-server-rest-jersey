package com.sdicons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

// The class has to be annotated with a Path annotation as well.
// The Jersey servlet scans for these annotations.
// Don't forget to add the package names that should be scanned to the web.xml, it is
// an init-parameter or the Jersey servlet.

@Path("/")
public class RestService {

    @Autowired
    @Qualifier("messageTemplate")
    String template;

    @GET
    @Path("/hello")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Message hello(@QueryParam("name") String name) {
        if(name == null) name = "World";
        return new Message(String.format(template, name));
    }

    @GET
    @Path("/hello2")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Message> hello2(@QueryParam("name") String name) {
        if(name == null) name = "World";
        return Arrays.asList(new Message("Testje"), new Message(String.format(template, name)));
    }
}
