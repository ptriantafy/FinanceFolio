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
            this.forum.get(i).getBody() + "\t" + 
            this.forum.get(i).getRating() +  "\n");
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
        System.out.println("\n" + "------Question------" + "\n" + this.forum.get(sel).getBody() + "\n");
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

}
