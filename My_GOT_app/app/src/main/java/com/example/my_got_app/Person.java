package com.example.my_got_app;

/**
 * The Person class creates objects with two fields -
 * an integer representing an image id
 * and a string representing the person's name
 *
 */

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
