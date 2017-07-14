package com.example.demo.todo.repository.mapper;

import com.example.demo.todo.model.TodoList;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by christophernorte on 14/07/17.
 */
@Component
public class TodoListRowMapper implements RowMapper<TodoList> {
    @Override
    public TodoList mapRow(ResultSet resultSet, int i) throws SQLException {
        TodoList todoList = new TodoList();
        todoList.setId(resultSet.getInt("id"));
        todoList.setLibelle(resultSet.getString("libelle"));
        return todoList;
    }
}
