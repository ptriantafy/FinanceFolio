package com.financefolio.forum;

import java.sql.Date;

import com.financefolio.dao.CommentDAO;

public class Comment {
    //attributes
    private int questionId;
    private int commentId;
    private String body;
    private Date date;
    private int authorId;
    private int upvotes;
    private int downvotes;
    //methods
    public Comment(int questionId, int commentId, String body,Date date,int authorId){
        this.questionId = questionId;
        this.commentId = commentId;
        this.body = body;
        this.date = date;//find method to return curr date
        this.authorId = authorId;
        this.upvotes = 0;
        this.downvotes = 0;
    }

    public int getQuestionId(){
        return questionId;
    }
    public int getCommentId() {
        return commentId;
    }
    public String getBody(){
        return body;
    }
    public int getAuthorId(){
        return authorId;
    }
    public int getUpvotes() {
        return upvotes;
    }
    public int getDownvotes() {
        return downvotes;
    }

    public void setCommentId(int commentId){
        this.commentId = commentId;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes; 
    }
    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }

}
