package com.example;

public class User {
    private String name;
    private boolean isMan;

    public User(String name, boolean isMan) {
        this.name = name;
        this.isMan = isMan;
    }

    public String getName() {
        return name;
    }

    public boolean isMan() {
        return isMan;
    }
}
