package com.financefolio.forum;

import java.sql.Date;
import java.util.*;


public class Question implements Comparable<Question>{
    private int questionId;
    private String title;
    private String body;
    private Date date;
    private int author_id;
    private int upvotes;
    private int downvotes;
    private float rating;
    private List<Comment> comments = new ArrayList<Comment>();


    public Question(int questionId ,String title, String body, Date date, int author_id){
        this.questionId = questionId;
        this.title = title;
        this.body = body;
        this.date = date;
        this.author_id = author_id;
        this.upvotes = 0;
        this.downvotes = 0;
        if(this.upvotes == 0 && this.downvotes == 0)
            this.rating = 0;
        else
            this.rating = (float)this.upvotes/this.downvotes;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
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

    public int getAuthorId() {
        return author_id;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComments(Comment... com) {
        Collections.addAll(comments , com);
    }
    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
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

    public void addCommentToQuestion(Comment sel){
        this.comments.add(sel);
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




