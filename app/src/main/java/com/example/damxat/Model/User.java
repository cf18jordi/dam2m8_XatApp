package com.example.damxat.Model;

public class User {
    //Properties
    String id;
    String username;
    String status;

    //Constructors
    public User(String id, String username, String status) {
        this.id = id;
        this.username = username;
    }

    public User() {
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getStatus(){
        return status;
    }

    //Setters
    public void setStatus(String status) {
        this.status = status;
    }
}
