package com.example.demo.todo.resource;

import com.example.demo.todo.model.State;
import com.example.demo.todo.model.Task;
import com.example.demo.todo.model.TodoList;
import com.example.demo.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 */
@Component
@Path("/todos/{idTodoList}/tasks")
public class TaskResource {

    @Autowired
    private TaskRepository taskRepository;

    @PathParam("idTodoList")
    private int idTodoList;

    @GET
    @Produces("application/json")
    public List<Task> all() {
        TodoList todoList = getRelatedTodoList();
        return taskRepository.all(todoList);
    }

    @POST
    @Consumes("application/json")
    public Response add(Task task) {
        TodoList todoList = getRelatedTodoList();
        task.setTodoList(todoList);

        if(task.getState() == null)
        {
            task.setState(State.TODO);
        }

        if(taskRepository.add(task))
        {
            return Response.status(Response.Status.CREATED).build();
        }else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Consumes("application/json")
    public Response delete(Task task) {


        if(taskRepository.delete(task))
        {
            return Response.status(Response.Status.NO_CONTENT).build();
        }else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Consumes("application/json")
    public Response update(Task task) {
        if(taskRepository.update(task))
        {
            return Response.status(Response.Status.OK).build();
        }else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    private TodoList getRelatedTodoList()
    {
        TodoList todoList = new TodoList();
        todoList.setId(idTodoList);
        return todoList;
    }

}
