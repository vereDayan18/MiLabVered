package com.example.my_got_app;

public class Person {
    private int imageId;
    private String name;

    public int getImageId(){
        return this.imageId;
    }

    public String getName(){
        return this.name;
    }

    public void setImageId(int id){
        this.imageId = id;
    }

    public void setName(String newText){
        this.name = newText;
    }
}
