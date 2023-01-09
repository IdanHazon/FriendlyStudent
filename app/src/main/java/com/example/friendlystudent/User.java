package com.example.friendlystudent;

import android.widget.ImageView;

import java.util.ArrayList;

public class User {
    private String name;
    private String email;


    private int contentCounter;
    private ArrayList<content>contents;
    private ImageView profilePic;
    private int friendlyPoints;
    private ArrayList<chat>chats;
    private int level;
    private ImageView levelPic;

    public User(String name, String email){
        this.name= name;
        this.email= email;
        this.level=1;
        this.contentCounter=0;
    }
    public User(){

    }
    public int getContentCounter() {
        return contentCounter;
    }

    public void setContentCounter(int contentCounter) {
        this.contentCounter = contentCounter;
    }

    public ArrayList<chat> getChats() {
        return chats;
    }
    public void setChats(ArrayList<chat> chats) {
        this.chats = chats;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public ImageView getLevelPic() {
        return levelPic;
    }
    public void setLevelPic(ImageView levelPic) {
        this.levelPic = levelPic;
    }
    public int getFriendlyPoints() {
        return friendlyPoints;
    }
    public void setFriendlyPoints(int friendlyPoints) {
        this.friendlyPoints = friendlyPoints;
    }
    public ImageView getProfilePic() {
        return profilePic;
    }
    public void setProfilePic(ImageView profilePic) {
        this.profilePic = profilePic;
    }
    public ArrayList<content> getContents() {
        return contents;
    }
    public void setContents(ArrayList<content> contents) {
        this.contents = contents;
    }
    public void setName(String name){
    this.name=name;
    }
    public void setEmail(String email){
    this.email=email;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }

}
