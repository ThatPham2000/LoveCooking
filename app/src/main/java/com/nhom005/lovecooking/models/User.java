package com.nhom005.lovecooking.models;

import java.io.Serializable;

public class User implements Serializable {
    public User(int avatar, String name, String education, String work, String website, int numberFollower, int numberStatus, boolean isFollowing) {
        this.avatar = avatar;
        this.education = education;
        this.work = work;
        this.website = website;
        this.name = name;
        this.numberFollower = numberFollower;
        this.numberStatus = numberStatus;
        this.isFollowing = isFollowing;
    }

    public User() {
    }

    public int avatar;
    public String education;
    public String work;
    public String website;
    public String name;
    public int numberFollower;
    public int numberStatus;
    public boolean isFollowing;
}
