package com.financefolio.goals;

import java.util.*;
import com.financefolio.dao.AchievementDAO;

public class AchievementList {
    private List<Achievement> achList = new ArrayList<Achievement>(); 

    //methods

    public void getAchievements()  {
        AchievementDAO ad = new AchievementDAO();
        try {
            achList = ad.getAll(0).get();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Achievement getAchievement(int index){
        return this.achList.get(index);
    }

    public void setViewAchievementsScene() {
        System.out.println("\n" + "------Unlocked Achievements------" + "\n");
        for (int i = 0; i < achList.size(); i++) {
            if(achList.get(i).getState().equals("UNLOCKED")){
                System.out.println((i + 1) + "." + achList.get(i).getDescription() + "\n" + 
                                "Reward: " + achList.get(i).getReward() + "\t" + 
                                "State: " + achList.get(i).getState() + "\n");
            }
            
        }
        System.out.println("\n" + "------Locked Achievements------" + "\n");
        for (int i = 0; i < achList.size(); i++) {
            if(achList.get(i).getState().equals("LOCKED")){
                System.out.println((i + 1) + "." + achList.get(i).getDescription() + "\n" + 
                                "Reward: " + achList.get(i).getReward() + "\t" + 
                                "State: " + achList.get(i).getState() + "\n");
            }
        }
    }
}
