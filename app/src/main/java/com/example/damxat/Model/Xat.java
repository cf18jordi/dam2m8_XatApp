package com.example.damxat.Model;

public class Xat {

    //Properties
    String sender;
    String receiver;
    String message;

    //Constructors
    public Xat(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public Xat() {

    }

    public Xat(String sender, String receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    //Getters
    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }
}
