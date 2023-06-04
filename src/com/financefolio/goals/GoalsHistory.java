package com.financefolio.goals;

import java.util.ArrayList;
import java.util.List;

import com.financefolio.dao.GoalDAO;

public class GoalsHistory {

    private List<Goal> activeGoals = new ArrayList<Goal>();
    private List<Goal> overallGoals = new ArrayList<Goal>();


    public Goal getGoal(int index){
        return this.activeGoals.get(index);
    }

    public void getActiveGoals() {
        GoalDAO gd = new GoalDAO();
        int dummy = 0;
        try {
            activeGoals = gd.getAll(dummy).get();
            // System.out.println("Hello");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setActiveGoalsScene(){
        System.out.println("------Active Goals------");
        for (int i = 0; i < this.activeGoals.size(); i++) {
            System.out.println((i+1) + "." + this.activeGoals.get(i).getName() + "\t" + 
                                "Status: " + this.activeGoals.get(i).getState() +  "\n" +
                                "Difficulty: " + this.activeGoals.get(i).getDifficulty() + "\t" +
                                "Time Duration: " + this.activeGoals.get(i).getTimeDuration() + "\n");
        }
    }

    public void setOverallGoalsScene(){

    }
}
