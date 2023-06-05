package com.financefolio.goals;

import java.util.*;
import com.financefolio.dao.AchievementDAO;

public class AchievementList {
    private List<Achievement> achList = new ArrayList<Achievement>(); 
    private List<Achievement> unlockedAch = new ArrayList<Achievement>();
    private List<Achievement> lockedAch = new ArrayList<Achievement>();
    private List<Achievement> orderedAch = new ArrayList<Achievement>();

    //methods

    public void getAchievements()  {
        AchievementDAO ad = new AchievementDAO();
        try {
            achList = ad.getAll(0).get();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void sortUnlockedLocked(){
        for (int i = 0; i < achList.size(); i++) {
            if(achList.get(i).getState().equals("UNLOCKED"))
                unlockedAch.add(achList.get(i));
            else
                lockedAch.add(achList.get(i));
        }
        orderedAch.addAll(unlockedAch);
        orderedAch.addAll(lockedAch);
    }
    public void setViewAchievementsScene() {
        System.out.println("------Achievements------");
        for (int i = 0; i < orderedAch.size(); i++) {
            System.out.println((i + 1) + "." + orderedAch.get(i).getDescription() + "\n" + 
                                "Reward: " + orderedAch.get(i).getReward() + "\t" + 
                                "State: " + orderedAch.get(i).getState() + "\n");
        }
    }
}
