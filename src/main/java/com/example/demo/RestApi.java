package com.example.demo;

import com.example.demo.mapper.DiscoveryMapper;
import com.example.demo.mapper.GamesMapper;
import com.google.gson.Gson;
import io.swagger.annotations.*;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Service
@Path("/test")
@Api(value = "Hello resource")
public class RestApi {

    @Autowired
    private GamesMapper mapper;

    @Autowired
    private DiscoveryMapper discoveryMapper;

    @GET
    @Path("/v1/games")
    @ApiOperation(value = "Gets a games from DB", response = RestApi.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hello resource found"),
            @ApiResponse(code = 404, message = "Hello resource not found")
    })
    public String getPort() {
        return new Gson().toJson(mapper.getGame());
    }

    @GET
    @Path("/v1/discovery")
    @ApiOperation(value = "Gets a discovery from DB", response = RestApi.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "discovery resource found"),
            @ApiResponse(code = 404, message = "discovery resource not found")
    })
    public String getDiscovery() {
        return new Gson().toJson(discoveryMapper.getService());
    }

    @GET
    @Path("/v2/{name}")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(value = "name", type = "String", required = true),
                    @ApiImplicitParam(value = "second_param", type = "String"),
            }
    )
    @ApiOperation(value = "Gets by name(taking discovery)", response = RestApi.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "discovery resource found"),
            @ApiResponse(code = 404, message = "discovery resource not found")
    })
    public String getbyName(@PathParam("name") String name, @HeaderParam("second_param") String secondParam) {
        System.out.println("****************************************");
        System.out.println(name);
        System.out.println(secondParam);
        System.out.println("****************************************");
        return new Gson().toJson(discoveryMapper.getService());
    }


}


