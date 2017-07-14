package com.example.demo.todo.resource;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 */
@Component
@Path("/todo")
public class TodoResource {

    @GET
    @Produces("application/json")
    public String add() {
        return "test";
    }

}
