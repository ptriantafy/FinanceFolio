package com.financefolio.forum;

import java.sql.Date;
import java.util.*;


public class Question implements Comparable<Question>{
    private String title;
    private String body;
    private Date date;
    private String author;
    private int upvotes;
    private int downvotes;
    private float rating;
    private List<Comment> comments = new ArrayList<Comment>();


    public Question(String title, String body, Date date, String author, int upvotes, int downvotes){
        this.title = title;
        this.body = body;
        this.date = date;
        this.author = author;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.rating = (float)this.upvotes/this.downvotes;
    }

    public String getTitle() {
        return title;
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

    public List<Comment> getComments(int sel) {
        return comments;
    }

    public void setComments(Comment... com) {
        Collections.addAll(comments , com);
    }
    public void setUpvotes(int upvotes) {
        this.upvotes++;
    }

    public void setDownvotes() {
        this.downvotes++;
    }

    public String getCommentsDetails() {
        String temp = "";
        for(int i = 0; i < comments.size(); i++){
           temp = temp + "\n\n" + i + "." + this.comments.get(i).getBody() + "\n" + "Author: " + this.comments.get(i).getAuthor() + 
           "\n" + "Upvotes: " + this.comments.get(i).getUpvotes() + "\t" + "Downvotes: " + this.comments.get(i).getDownvotes();
        }
        return temp;
    }


    public float getRating() {
        return rating;
    }

    public void addCommentToQuestion(){
        // this.comments.add()
    }

    public void registerVoteOnSelectedComment(int sel, int updown){
        if(updown == 0)
            comments.get(sel).setUpvotes();
        else
            comments.get(sel).setDownvotes();
    }

    @Override
    public int compareTo(Question o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}




