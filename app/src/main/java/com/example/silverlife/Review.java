package com.example.silverlife;

public class Review {
    private String userName;
    private String text;

    public Review(String userName, String text) {
        this.userName = userName;
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public String getText() {
        return text;
    }
}