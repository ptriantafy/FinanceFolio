package com.financefolio.forum;

import java.util.*;

import com.financefolio.dao.QuestionDAO;

public class Forum {
    //attributes
    private List<Question> forum = new ArrayList <Question>();
    //methods
    public void setForumScene(){
        for(int i = 0; i < this.forum.size(); i++){
            System.out.println((i+1) + "." + this.forum.get(i).getTitle() + "\n" +
            this.forum.get(i).getBody() + "\n" + 
            "Upvotes:" + this.forum.get(i).getUpvotes() + "\t" + "Downvotes:" + this.forum.get(i).getDownvotes() + "\n");
        }
        //test
        // for (int i = 0; i < this.forum.size(); i++) {
        //     System.out.println(this.forum.get(i).getQuestionId());
        // }
    }
    public void sortByRating()
    {
        Collections.sort(forum, new Comparator<Question>() {    //Custom comparator for float objects
            @Override
            public int compare(Question q1, Question q2){
                return Float.compare(q2.getRating(), q1.getRating());
            }            
        });
    }

    public void getQuestions() throws Exception{
        int dummy = 0;
        QuestionDAO qd = new QuestionDAO();
        try {
            forum = qd.getAll(dummy).get();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Question getQuestion(int sel){
        return this.forum.get(sel);
    }

    public void setViewQuestionScene(int sel){
        System.out.println("\n" + "------Question------" + "\n" + this.forum.get(sel).getBody() + "\t" + this.forum.get(sel).getQuestionId() + "\n" +
        "Upvotes:" + this.forum.get(sel).getUpvotes() + "\t" + "Downvotes:" + this.forum.get(sel).getDownvotes() + "\n");
    }
    public Question searchQuestion(String input){
        int final1 = 0;
        for(int i = 0; i < this.forum.size(); i++)
        {
            if(this.forum.get(i).getTitle().contains(input) || this.forum.get(i).getBody().contains(input)){
                setViewQuestionScene(i);
                final1 = i;
            }
        }
        return this.forum.get(final1);
    }

    public void addQuestion(Question que,String dummy[]){
        QuestionDAO qd  = new QuestionDAO();
        try {
            qd.save(que, dummy);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void registerVoteOnQuestion(boolean updown, Question que_sel) {
        QuestionDAO qd = new QuestionDAO();
        try {
            if (updown) {
                que_sel.setUpvotes(que_sel.getUpvotes() + 1);
                System.out.println(que_sel.getUpvotes());
            } else {
                que_sel.setDownvotes(que_sel.getDownvotes() + 1);
            }
            qd.update(que_sel);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    

    // public void registerVoteOnQuestion(boolean updown, Question que_sel){
    //     QuestionDAO qd = new QuestionDAO();
    //     if(updown == true){
    //         que_sel.setUpvotes(que_sel.getUpvotes()+1);
    //         System.out.println(que_sel.getUpvotes());
    //     }
    //     else if (updown == false){
    //         que_sel.setDownvotes(que_sel.getDownvotes()+1);   
    //     }
    //     else
    //         System.out.println("Error in registering vote");

    //     try {
    //         qd.update(que_sel);
    //     } catch (Exception e) {
    //         System.out.println(e);
    //     }

    // }

}
