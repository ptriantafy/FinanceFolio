package com.financefolio.goals;

import java.util.ArrayList;
import java.util.List;

import com.financefolio.dao.GoalDAO;

public class GoalsHistory {

    private List<Goal> Goals = new ArrayList<Goal>();


    public Goal getGoal(int index){
        return this.Goals.get(index);
    }

    public void getGoals(int ownerId) {
        GoalDAO gd = new GoalDAO();
        int dummy = 0;
        try {
            Goals = gd.getAll(ownerId).get();
            // System.out.println("Hello");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setGoalsScene(){
        System.out.println("------Active Goals------");
        for (int i = 0; i < this.Goals.size(); i++) {
            if(Goals.get(i).getState().equals("in_progress"))
                System.out.println((i+1) + "." + this.Goals.get(i).getName() + "\t" + 
                                "Status: " + this.Goals.get(i).getState() +  "\n" +
                                "Difficulty: " + this.Goals.get(i).getDifficulty() + "\t" +
                                "Time Duration: " + this.Goals.get(i).getTimeDuration() + "\n");
            }
    
        System.out.println("------Completed Goals------");
        for (int i = 0; i < this.Goals.size(); i++) {
            if(Goals.get(i).getState().equals("completed")){
                System.out.println((i+1) + "." + this.Goals.get(i).getName() + "\t" + 
                                "Status: " + this.Goals.get(i).getState() +  "\n" +
                                "Difficulty: " + this.Goals.get(i).getDifficulty() + "\t" +
                                "Time Duration: " + this.Goals.get(i).getTimeDuration() + "\n");
            }
        }
        System.out.println("------Failed Goals------");
        for (int i = 0; i < this.Goals.size(); i++) {
            if(Goals.get(i).getState().equals("failed")){
                System.out.println((i+1) + "." + this.Goals.get(i).getName() + "\t" + 
                                "Status: " + this.Goals.get(i).getState() +  "\n" +
                                "Difficulty: " + this.Goals.get(i).getDifficulty() + "\t" +
                                "Time Duration: " + this.Goals.get(i).getTimeDuration() + "\n");
            }
        }
    }

    public void setOverallGoalsScene(){

    }
}
