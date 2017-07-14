package com.example.demo.todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by christophernorte on 14/07/17.
 */
@AllArgsConstructor
@Getter
@Setter
public class Task {
    private int id;
    private String name;
    private Task task;
    private State state;
}
