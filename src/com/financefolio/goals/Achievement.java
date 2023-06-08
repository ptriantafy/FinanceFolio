package com.financefolio.goals;
public class Achievement {
    private int achievementId;  
    private String description;
    private String type;
    private String state;
    private int reward;
    private int timeToComplete; //measured in days

    public Achievement(String descString, String typeString, int timeToComplete) {
        this.description = descString;
        this.type = typeString;
        this.timeToComplete = timeToComplete;
    }

    //#region getters and setters

    public int getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(int achievementId) {
        this.achievementId = achievementId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(){
        this.reward += this.timeToComplete*0.5;
    }

    public int getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(int timeToComplete) {
        this.timeToComplete = timeToComplete;
    }
    //#endregion
    
    //#region methods
    

    //#endregion
}
