package com.example.friendlystudent;

public class User {
    private String name;
    private String email;
    private String password;

    public User(){
    }
    public void setName(String name){
    this.name=name;
    }
    public void setEmail(String email){
    this.email=email;
    }
    public void setPassword(String password){
    this.password=password;
    }
    public String getName(){
        return name;
    }
}
