package com.example.demo.todo.resource;

import com.example.demo.todo.model.TodoList;
import com.example.demo.todo.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

}
