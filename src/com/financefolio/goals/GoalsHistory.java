package com.financefolio.goals;

import java.util.ArrayList;
import java.util.List;

import com.financefolio.dao.GoalDAO;

public class GoalsHistory {

    private List<Goal> goalsHistory = new ArrayList<Goal>();


    public Goal getGoal(int index){
        return this.goalsHistory.get(index);
    }

    public void getGoals(int ownerId) {
        GoalDAO gd = new GoalDAO();
        try {
            goalsHistory = gd.getAll(ownerId).get();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setGoalsScene(){
        System.out.println("------Active Goals------");
        for (int i = 0; i < this.goalsHistory.size(); i++) {
            if(goalsHistory.get(i).getState().equals("in_progress"))
                System.out.println((i+1) + "." + this.goalsHistory.get(i).getName() + "\t" + 
                                "Status: " + this.goalsHistory.get(i).getState() +  "\n" +
                                "Difficulty: " + this.goalsHistory.get(i).getDifficulty() + "\t" +
                                "Time Duration: " + this.goalsHistory.get(i).getTimeDuration() + "\n");
            }
    
        System.out.println("------Completed Goals------");
        for (int i = 0; i < this.goalsHistory.size(); i++) {
            if(goalsHistory.get(i).getState().equals("completed")){
                System.out.println((i+1) + "." + this.goalsHistory.get(i).getName() + "\t" + 
                                "Status: " + this.goalsHistory.get(i).getState() +  "\n" +
                                "Difficulty: " + this.goalsHistory.get(i).getDifficulty() + "\t" +
                                "Time Duration: " + this.goalsHistory.get(i).getTimeDuration() + "\n");
            }
        }
        System.out.println("------Failed Goals------");
        for (int i = 0; i < this.goalsHistory.size(); i++) {
            if(goalsHistory.get(i).getState().equals("failed")){
                System.out.println((i+1) + "." + this.goalsHistory.get(i).getName() + "\t" + 
                                "Status: " + this.goalsHistory.get(i).getState() +  "\n" +
                                "Difficulty: " + this.goalsHistory.get(i).getDifficulty() + "\t" +
                                "Time Duration: " + this.goalsHistory.get(i).getTimeDuration() + "\n");
            }
        }
    }
}
