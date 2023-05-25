package com.financefolio.forum;

import java.util.*;

public class Forum {
    //attributes
    private List<Question> forum = new ArrayList<Question>();
    //methods
    public void sortByRating()
    {

    }

    public void getForum() {
        for(int i =0; i<this.forum.size(); i++){
            System.out.println(this.forum.get(i).getBody()+this.forum.get(i).getRating());
        }
    }

    public void getAll(Question que){
        forum.add(que);   
    }
    public void addCommentToQuestion(){}
    public void registerVoteOnSelectedComment(){}
    public Question getQuestionSelected(){
        return null;}
    public Question searchQuestion(){
        return null;}

}
