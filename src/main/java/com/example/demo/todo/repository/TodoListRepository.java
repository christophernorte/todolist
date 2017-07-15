package com.example.demo.todo.repository;

import com.example.demo.todo.model.TodoList;
import com.example.demo.todo.repository.mapper.TodoListRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by christophernorte on 14/07/17.
 */
@Component
public class TodoListRepository {

    private static final String INSERT="INSERT INTO TODOLIST (LIBELLE) VALUES (?)";
    private static final String SELECT_ALL="SELECT * FROM TODOLIST";
    private static final String DELETE="DELETE FROM TODOLIST WHERE id=?";
    private static final String UPDATE="UPDATE TODOLIST SET LIBELLE=? WHERE id=?";

    @Autowired
    private TodoListRowMapper todoListRowMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean add(TodoList todoList)
    {
        int rows = jdbcTemplate.update(INSERT,todoList.getLibelle());
        return rows > 0;
    }

    public boolean delete(TodoList todoList)
    {
        int rows = jdbcTemplate.update(DELETE,todoList.getId());
        return rows > 0;
    }

    public boolean update(TodoList todoList)
    {
        int rows = jdbcTemplate.update(UPDATE,todoList.getLibelle(),todoList.getId());
        return rows > 0;
    }

    public List<TodoList> all()
    {
        return jdbcTemplate.query(SELECT_ALL,todoListRowMapper);
    }
}
