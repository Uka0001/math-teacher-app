package org.example.model;

public enum Command {
    ADD_EQUATION("add equation to database"),
    GET_BY_ROOT_NAME("get equation by root value"),
    GET_BY_ROOT_NUMBER("get equation by root number"),
    HELP("get help with command app"),
    EXIT("exit from app");

    private String description;

    Command(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
