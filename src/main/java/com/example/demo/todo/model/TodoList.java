package com.example.demo.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class TodoList {
    @JsonIgnore
    private int id;
    private String libelle;

}
