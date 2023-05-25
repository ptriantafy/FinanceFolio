package com.financefolio.forum;

import java.util.*;

public class Forum {
    //attributes
    private List<Question> forum = new ArrayList<Question>();
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

    public void getForum() {
        System.out.println("------Forum Questions------");
        for(int i = 0; i<this.forum.size(); i++){
            System.out.println(i + "." + this.forum.get(i).getBody() + " " + this.forum.get(i).getRating());
        }
    }

    public void getAll(Question... que){
        Collections.addAll(forum, que);
    }
    public void registerVoteOnSelectedComment(){

    }
    public void getQuestionSelected(int sel){
        System.out.println(this.forum.get(sel).getBody() + "\n" + "Author: " + this.forum.get(sel).getAuthor() + "\n" +
        "\n" + "------Comments------" + this.forum.get(sel).getCommentsDetails());
    }
    public Question searchQuestion(String input){
        for(int i = 0; i < this.forum.size(); i++)
        {
            if(this.forum.get(i).getTitle().contains(input) || this.forum.get(i).getBody().contains(input))
                getQuestionSelected(i);
        }
        return null;
    }

}
