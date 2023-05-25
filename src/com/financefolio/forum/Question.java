package com.financefolio.forum;

import java.sql.Date;
import java.util.*;


public class Question implements Comparable<Question>{
    private String body;
    private Date date;
    private String author;
    private int upvotes;
    private int downvotes;
    private float rating;
    private List<Comment> comments = new ArrayList<Comment>();

    public Question(String body, Date date, String author, int upvotes, int downvotes){
        this.body = body;
        this.date = date;
        this.author = author;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.rating = (float)this.upvotes/this.downvotes;
    }

    public String getBody() {
        return body;
    }

    public Date getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setComments(Comment... com) {
        Collections.addAll(comments , com);
    }

    public String getComments() {
        String temp = "";
        for(int i = 0; i < comments.size(); i++){
           temp = temp + "\n" + this.comments.get(i).getBody() + "\n" + "Author: " + this.comments.get(i).getAuthor();
        }
        return temp;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public int compareTo(Question o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}




