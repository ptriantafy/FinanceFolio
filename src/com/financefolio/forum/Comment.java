package com.financefolio.forum;

import java.sql.Date;

public class Comment {
    //attributes
    private int commentId;
    private String body;
    private Date date;
    private int authorId;
    private int upvotes;
    private int downvotes;
    //methods
    public Comment(int commentId, String body,Date date,int authorId){
        this.commentId = commentId;
        this.body = body;
        this.date = date;//find method to return curr date
        this.authorId = authorId;
        this.upvotes = 0;
        this.downvotes = 0;
    }
    public String getBody(){
        return body;
    }
    public int getauthorId(){
        return authorId;
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

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes; 
    }
    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }
    
}
