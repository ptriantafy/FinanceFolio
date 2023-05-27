package com.financefolio.goals;

public class Goal {
    //attributes
    private String name;
    private String state;
    private boolean shared;
    private long timeDuration;
    private float moneyToSpend;
    private int difficulty;
    private int reward;

    //methods
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

    public int estimateDifficulty(){
        return 0;
    }

    public int getReward(){
        return 0;
    }

    public void modifyGoal(){}
        
    public void updateGoal(){}

    public void deleteGoal(){}
}
