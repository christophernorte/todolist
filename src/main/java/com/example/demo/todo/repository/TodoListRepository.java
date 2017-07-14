package com.example.demo.todo.repository;

import com.example.demo.todo.model.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by christophernorte on 14/07/17.
 */
public class TodoListRepository {

//    private static final INSERT=""

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private void add(TodoList todoList)
    {
//        jdbcTemplate.update();
    }
}
