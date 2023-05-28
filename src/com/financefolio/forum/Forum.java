package com.financefolio.forum;

import java.util.*;
import java.util.concurrent.ExecutionException;

import com.financefolio.dao.QuestionDAO;

public class Forum {
    //attributes
    private List<Question> forum = new ArrayList <Question>();
    //DAO
    QuestionDAO qd = new QuestionDAO();
    //methods
    public void sortByRating()
    {
        Collections.sort(forum, new Comparator<Question>() {    //Custom comparator for float objects
            @Override
            public int compare(Question q1, Question q2){
                return Float.compare(q2.getRating(), q1.getRating());
            }            
        });
    }

    public void getForum() throws Exception{
        qd.connect();
        forum = qd.getAll();
        System.out.println("------Forum Questions------");
        for(int i = 0; i<this.forum.size(); i++){
            System.out.println(i + "." + this.forum.get(i).getBody() + " " + this.forum.get(i).getRating());
        }
    }

    public void getAll(Question... que){
        Collections.addAll(forum, que);
    }

    public Question getQuestion(int sel){
        return this.forum.get(sel);
    }

    public void getQuestionSelected(int sel){
        System.out.println("\n" + "------Question------" + "\n" + this.forum.get(sel).getBody() + "\n" + "\n\n" + 
        "------Comments------" + this.forum.get(sel).getCommentsDetails());
    }
    public Question searchQuestion(String input){
        int final1 = 0;
        for(int i = 0; i < this.forum.size(); i++)
        {
            if(this.forum.get(i).getTitle().contains(input) || this.forum.get(i).getBody().contains(input)){
                getQuestionSelected(i);
                final1 = i;
            }
        }
        return this.forum.get(final1);
    }

    public void addQuestion(){
        //give question_id -1 value
    }

}
