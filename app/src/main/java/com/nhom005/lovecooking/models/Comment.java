package com.nhom005.lovecooking.models;

import java.util.ArrayList;
import java.util.Date;

public class Comment {
    public User user;
    public String content;
    public int numberLove = 12;
    public Date time;
    public ArrayList<Comment> reply = new ArrayList<>();
    public boolean isLoving = false;
    public boolean isReply = false;

    public Comment(User user, String content) {
        this.user = user;
        this.content = content;

    }

    public Comment() {
    }
}
