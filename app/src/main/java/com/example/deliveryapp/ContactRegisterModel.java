package com.example.deliveryapp;

public class ContactRegisterModel {
    String name, interested, message;

    public ContactRegisterModel() {
    }

    public ContactRegisterModel(String name, String interested, String message) {
        this.name = name;
        this.interested = interested;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInterested() {
        return interested;
    }

    public void setInterested(String interested) {
        this.interested = interested;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
