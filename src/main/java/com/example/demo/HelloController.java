package com.example.demo;

import com.example.demo.services.Animal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Service
@Path("/bla")
public class HelloController {

    @GET
    public String index() {
        return "Greetings from Spring Boot!";
    }

    private String serviceName = "";

//    @GET
//    @Path("/test/{service}")
//    public String multiImplementations(@PathParam("service") String service , @Qualifier()) {
//        @
//
//    }
//
//    String getLegs(@Qualifier(serviceName))

}