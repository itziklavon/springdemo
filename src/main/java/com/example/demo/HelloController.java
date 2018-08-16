package com.example.demo;

import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Service
@Path("/test/v2")
public class HelloController {

    private String serviceName = "";

    @GET
    public String index() {
        return "Greetings from Spring Boot!";
    }

//    @GET
//    @Path("/test/{service}")
//    public String multiImplementations(@PathParam("service") String service , @Qualifier()) {
//        @
//
//    }
//
//    String getLegs(@Qualifier(serviceName))

}