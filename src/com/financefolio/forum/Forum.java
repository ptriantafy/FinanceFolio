package com.financefolio.forum;

import java.util.*;

import com.financefolio.dao.QuestionDAO;

public class Forum {
    //attributes
    private List<Question> forum = new ArrayList <Question>();
    private List<Question> search_result = new ArrayList<Question>();
    //methods
    public void setForumScene(){
        for(int i = 0; i < this.forum.size(); i++){
            System.out.println((i+1) + "." + this.forum.get(i).getTitle() + "\n");
        }
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
        System.out.println("\n" + "------Question------" + "\n" + 
        this.forum.get(sel).getTitle() + "\n\n" +
        this.forum.get(sel).getBody() + "\n" + 
        "Upvotes:" + this.forum.get(sel).getUpvotes() + "\t" + 
        "Downvotes:" + this.forum.get(sel).getDownvotes() + "\n");
    }
    public void searchQuestion(String input){
        for(int i = 0; i < this.forum.size(); i++)
        {
            if(this.forum.get(i).getTitle().contains(input) || this.forum.get(i).getBody().contains(input)){
                search_result.add(this.forum.get(i));
            }
        }
        System.out.println("Questions matching to inputs: " + "\n");
        for(int j = 0; j < search_result.size(); j++)
        {
            System.out.println((j+1) + "." + 
            search_result.get(j).getTitle() + "\n");
        }
    }

    public void addQuestion(Question que,String dummy[]){
        QuestionDAO qd  = new QuestionDAO();
        try {
            qd.save(que, dummy);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void registerVoteOnQuestion(int vote, Question que_sel) {
        QuestionDAO qd = new QuestionDAO();
        try {
            if (vote == 0) {
                que_sel.setUpvotes(que_sel.getUpvotes() + 1);
            } else {
                que_sel.setDownvotes(que_sel.getDownvotes() + 1);
            }
            qd.update(que_sel);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
