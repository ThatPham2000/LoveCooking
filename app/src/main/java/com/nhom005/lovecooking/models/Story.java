package com.nhom005.lovecooking.models;

public class Story {
    private int avatar;
    private int imageContent;

    public Story(int avatar, int imageContent) {
        this.avatar = avatar;
        this.imageContent = imageContent;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getImageContent() {
        return imageContent;
    }

    public void setImageContent(int imageContent) {
        this.imageContent = imageContent;
    }
}
