package com.nhom005.lovecooking.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class FeedNews implements Serializable {
    public FeedNews(User user, ArrayList<Integer> images, String ulrVideo, String title, String material, ArrayList<String> howToDoIt, String experience, int numberLove, int numberComment, float rating, boolean isLoving, String timeUpload) {
        this.user = user;
        this.images = images;
        this.ulrVideo = ulrVideo;
        this.title = title;
        this.material = material;
        this.howToDoIt = howToDoIt;
        this.experience = experience;
        this.numberLove = numberLove;
        this.numberComment = numberComment;
        this.rating = rating;
        this.isLoving = isLoving;
        this.timeUpload = timeUpload;
    }

    public FeedNews(){}

    public User user;
    public ArrayList<Integer> images;
    public String ulrVideo;
    public String title;
    public String material;
    public ArrayList<String> howToDoIt;
    public String experience;
    public int numberLove;
    public int numberComment;
    public float rating;
    public boolean isLoving;
    public String timeUpload;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Integer> getImages() {
        return images;
    }

    public void setImages(ArrayList<Integer> images) {
        this.images = images;
    }

    public String getUlrVideo() {
        return ulrVideo;
    }

    public void setUlrVideo(String ulrVideo) {
        this.ulrVideo = ulrVideo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public ArrayList<String> getHowToDoIt() {
        return howToDoIt;
    }

    public void setHowToDoIt(ArrayList<String> howToDoIt) {
        this.howToDoIt = howToDoIt;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getNumberLove() {
        return numberLove;
    }

    public void setNumberLove(int numberLove) {
        this.numberLove = numberLove;
    }

    public int getNumberComment() {
        return numberComment;
    }

    public void setNumberComment(int numberComment) {
        this.numberComment = numberComment;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isLoving() {
        return isLoving;
    }

    public void setLoving(boolean loving) {
        isLoving = loving;
    }

    public String getTimeUpload() {
        return timeUpload;
    }

    public void setTimeUpload(String timeUpload) {
        this.timeUpload = timeUpload;
    }
}
