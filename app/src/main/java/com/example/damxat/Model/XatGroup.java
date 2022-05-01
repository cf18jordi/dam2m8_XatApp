package com.example.damxat.Model;

import java.util.ArrayList;

public class XatGroup {
    //Properties
    String name;
    ArrayList<String> users;
    ArrayList<Xat> xats;

    //Constructors
    public XatGroup(String name) {
        this.name = name;

    }

    public XatGroup() {
    }

    //Getters
    public String getName() {
        return name;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public ArrayList<Xat> getXats() {
        return xats;
    }
}
