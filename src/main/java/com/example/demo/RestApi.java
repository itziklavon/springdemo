package com.example.demo;

import com.example.demo.mapper.DiscoveryMapper;
import com.example.demo.mapper.GamesMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Service
@Path("/test/v1")
public class RestApi {

    @Autowired
    private GamesMapper mapper;

    @Autowired
    private DiscoveryMapper discoveryMapper;

    @GET
    @Path("/games")
    public String getPort() {
        return new Gson().toJson(mapper.getGame());
    }

    @GET
    @Path("/discovery")
    public String getDiscovery() {
        return new Gson().toJson(discoveryMapper.getService());
    }

}


