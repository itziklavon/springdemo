package com.example.demo;

import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Service
@Path("/bla")
public class HelloController {

    @GET
    public String index() {
        return "Greetings from Spring Boot!";
    }

}