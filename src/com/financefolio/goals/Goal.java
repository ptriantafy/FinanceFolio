package com.financefolio.goals;

import com.financefolio.dao.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Goal {
    //attributes
    private int goalId;
    private int ownerId;
    private String name;
    private String state;
    private boolean shared;
    private long timeDuration;
    private float moneyToSpend;
    private int difficulty;
    private int reward;
    private List<Goal> activeGoals = new ArrayList<Goal>();


    //methods
    public Goal(int goalId, int ownerId, String nameString, String stateString, boolean shared, long timeDuration, float moneyToSpend) {
        this.goalId = goalId;
        this.ownerId = ownerId;
        this.name = nameString;
        this.state = stateString;
        this.shared = shared;
        this.timeDuration = timeDuration;
        this.moneyToSpend = moneyToSpend;
    }


    //#region getters and setters

    public int getGoalId() {
        return goalId;
    }


    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }


    public int getOwnerId() {
        return ownerId;
    }


    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public long getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(long timeDuration) {
        this.timeDuration = timeDuration;
    }

    public float getMoneyToSpend() {
        return moneyToSpend;
    }

    public void setMoneyToSpend(float moneyToSpend) {
        this.moneyToSpend = moneyToSpend;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }
    
    public int getReward(){
        return reward;
    }

    //#endregion
    
    
    public void estimateDifficulty(){
        Random rand = new Random();
        //produces a random number from 1 to 10
        int result = rand.nextInt((10 - 1) + 1) + 1; 
        this.setDifficulty(result);
    }


    public void setActiveGoalsScene(){

    }

    public void modifyGoal(){}
        
    public void updateGoal(){}

    public void deleteGoal(){}
}
