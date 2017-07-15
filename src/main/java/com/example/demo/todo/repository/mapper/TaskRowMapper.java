package com.example.demo.todo.repository.mapper;

import com.example.demo.todo.model.State;
import com.example.demo.todo.model.Task;
import com.example.demo.todo.model.TodoList;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by christophernorte on 14/07/17.
 */
@Component
public class TaskRowMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        Task task = new Task();
        task.setId(resultSet.getInt("id"));
        task.setName(resultSet.getString("name"));

        State state = State.valueOf(resultSet.getString("state"));
        task.setState(state);

        TodoList todoList = new TodoList();
        todoList.setId(resultSet.getInt("IDTODOLIST"));
        task.setTodoList(todoList);
        return task;
    }
}
