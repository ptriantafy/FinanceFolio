package com.financefolio.forum;

import java.sql.Date;

public class Comment {
    //attributes
    private String body;
    private Date date;
    private String author;
    private int upvotes;
    private int downvotes;
    //methods
    public Comment(String body,Date date,String author, int upvotes, int downvotes){
        this.body = body;
        this.date = date;
        this.author = author;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }
    public String getBody(){
        return body;
    }
    public String getAuthor(){
        return author;
    }
    public int getUpvotes() {
        return upvotes;
    }
    public int getDownvotes() {
        return downvotes;
    }
    public void requestInsert(){}
    public void requestUpdate(){}
    public void addVote(){
    }

    public void setUpvotes() {
        this.upvotes++; 
    }
    public void setDownvotes() {
        this.downvotes++;
    }
    
}
