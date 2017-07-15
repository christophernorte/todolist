package com.example.demo.todo.config;

import com.example.demo.todo.resource.TaskResource;
import com.example.demo.todo.resource.TodoResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ext.Provider;

/**
 * Created by christophernorte on 14/07/17.
 */
@Configuration
public class RestConfig extends ResourceConfig{

    public RestConfig() {
        register(TodoResource.class);
        register(TaskResource.class);
    }
}
