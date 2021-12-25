package com.nhom005.lovecooking.models;

public class AlbumPicker {
    private String name;
    private int number;
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public AlbumPicker(String name, int number, int image) {
        this.name = name;
        this.number = number;
        this.image = image;
    }
}
