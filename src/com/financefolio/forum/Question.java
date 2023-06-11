package com.financefolio.forum;

import java.sql.Date;
import java.util.*;

import com.financefolio.dao.CommentDAO;
import com.financefolio.dao.QuestionDAO;


public class Question implements Comparable<Question>{
    private int questionId;
    private String title;
    private String body;
    private Date date;
    private int authorId;
    private int upvotes;
    private int downvotes;
    private float rating;
    private List<Comment> comments = new ArrayList<Comment>();


    public Question(int questionId ,String title, String body, Date date, int authorId){
        this.questionId = questionId;
        this.title = title;
        this.body = body;
        this.date = date;
        this.authorId = authorId;
    }
//#region
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
        return authorId;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public int getDownvotes() {
        return downvotes;
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
    
    public float getRating() {
        return rating;
    }

    public void setRating(){
        this.rating = this.upvotes-this.downvotes;
    }
// #endregion

    public Comment getComment(int sel){
        return this.comments.get(sel);
    }

    public void getComments() throws Exception {
        CommentDAO cd = new CommentDAO();
        try {
            comments = cd.getAll(this.questionId).get();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void setViewCommentsScene() {
        System.out.println("-------Comments------");
        for(int i = 0; i < comments.size(); ++i){
            System.out.println((i+1) + "." + 
            this.comments.get(i).getBody() + "\n\n" +  
            "Upvotes: " + this.comments.get(i).getUpvotes() + "\t" + 
            "Downvotes: " + this.comments.get(i).getDownvotes() + "\n");
        }
    }

    public void addCommentToQuestion(Comment sel, String[] dummy) {
        CommentDAO cd = new CommentDAO();
        try {
            cd.save(sel, dummy);
        } catch (Exception e) {
            e.printStackTrace(); // Print the exception stack trace for debugging
        }
    }
    public void registerVoteOnComment(Comment com, int vote){
    
        CommentDAO cd = new CommentDAO();
        try {
          if(vote == 0)
              com.setUpvotes(com.getUpvotes() + 1);
          else
              com.setDownvotes(com.getDownvotes() + 1);
          cd.update(com, null);
        } catch (Exception e) {
          System.out.println(e);
        }  
      }

    @Override
    public int compareTo(Question o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}




