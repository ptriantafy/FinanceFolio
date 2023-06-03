package com.financefolio.goals;

import java.util.ArrayList;
import java.util.List;

import com.financefolio.dao.GoalDAO;

public class GoalsHistory {

    private List<Goal> activeGoals = new ArrayList<Goal>();
    private List<Goal> overallGoals = new ArrayList<Goal>();


    public void getActiveGoals() {
        GoalDAO gd = new GoalDAO();
        try {
            activeGoals = gd.getAll(0).get();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setActiveGoalsScene(){
        for (int i = 0; i < this.activeGoals.size(); i++) {
            System.out.println("------Active Goals------" + "\n" + 
                                (i+1) + "." + this.activeGoals.get(i).getName() + "\t" + 
                                "Status: " + this.activeGoals.get(i).getState() +  "\n" +
                                "Difficulty: " + this.activeGoals.get(i).getDifficulty() + "\t" +
                                "Time Duration: " + this.activeGoals.get(i).getTimeDuration());
        }
    }

    public void setOverallGoalsScene(){

    }
}
