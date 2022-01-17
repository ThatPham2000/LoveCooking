package com.nhom005.lovecooking.utils;

import com.nhom005.lovecooking.models.Comment;
import com.nhom005.lovecooking.models.FeedNews;
import com.nhom005.lovecooking.models.User;

import java.util.ArrayList;

public class Constants {
    public static final String KEY_FEED_NEWS = "KEY_FEED_NEWS";
    public static final String KEY_TEXT_SEARCH = "KEY_TEXT_SEARCH";
    public static final String KEY_USER = "KEY_USER";

    public static ArrayList<User> historyUser = new ArrayList<>();
    public static ArrayList<String> historyTextSearch = new ArrayList<>();
    public static ArrayList<FeedNews> feedNews = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<User> userResult = new ArrayList<>();
    public static ArrayList<FeedNews> postResult = new ArrayList<>();
    public static ArrayList allResult = new ArrayList();
    public static ArrayList<Comment> comments = new ArrayList<>();

}
