package com.example.demo.todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by christophernorte on 14/07/17.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    private int id;
    private String name;
    private TodoList todoList;
    private State state;
}
