package com.example.demo.todo.resource;

import com.example.demo.todo.model.TodoList;
import com.example.demo.todo.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 */
@Component
@Path("/todo")
public class TodoResource {

    @Autowired
    private TodoListRepository todoListRepository;

    @GET
    @Produces("application/json")
    public List<TodoList> all() {
        return todoListRepository.all();
    }

    @POST
    @Path("/add")
    @Consumes("application/json")
    public Response add(TodoList todoList) {
        if(todoListRepository.add(todoList))
        {
            return Response.status(Response.Status.CREATED).build();
        }else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/delete")
    @Consumes("application/json")
    public Response delete(TodoList todoList) {
        if(todoListRepository.delete(todoList))
        {
            return Response.status(Response.Status.OK).build();
        }else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
