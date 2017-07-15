package com.example.demo.todo.repository;

import com.example.demo.todo.model.Task;
import com.example.demo.todo.model.TodoList;
import com.example.demo.todo.repository.mapper.TaskRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by christophernorte on 14/07/17.
 */
@Component
public class TaskRepository {

    private static final String INSERT="INSERT INTO TASK (NAME,STATE,IDTODOLIST) VALUES (?,?,?)";
    private static final String SELECT_ALL="SELECT * FROM TASK WHERE IDTODOLIST=?";
    private static final String DELETE="DELETE FROM TASK WHERE id=?";
    private static final String UPDATE="UPDATE TASK SET LIBELLE=?,STATE=?,IDTODOLIST=? WHERE id=?";

    @Autowired
    private TaskRowMapper taskRowMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean add(Task task)
    {
        int rows = jdbcTemplate.update(INSERT,task.getName(),task.getState().toString(),task.getTodoList().getId());
        return rows > 0;
    }

    public boolean delete(Task task)
    {
        int rows = jdbcTemplate.update(DELETE,task.getId());
        return rows > 0;
    }

    public boolean update(Task task)
    {
        int rows = jdbcTemplate.update(UPDATE,task.getName(),task.getState(),task.getTodoList().getId());
        return rows > 0;
    }

    public List<Task> all(TodoList todoList)
    {
        return jdbcTemplate.query(SELECT_ALL, taskRowMapper,todoList.getId());
    }
}
