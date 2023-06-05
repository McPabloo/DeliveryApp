package com.example.deliveryapp;

import android.os.Parcel;
import android.os.Parcelable;

public class ContactRegisterModel {
    private String id, name, interested, message;

    public ContactRegisterModel() {
    }

    public ContactRegisterModel(String id,String name, String interested, String message) {
        this.id = id;
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
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
