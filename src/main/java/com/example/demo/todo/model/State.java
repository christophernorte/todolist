package com.example.demo.todo.model;

/**
 * Created by christophernorte on 14/07/17.
 */
public enum State {
    TODO("TODO"),DONE("DONE"),INACTIVE("INACTIVE");

    private String state;

    State(String state) {
        this.state = state;
    }
}
