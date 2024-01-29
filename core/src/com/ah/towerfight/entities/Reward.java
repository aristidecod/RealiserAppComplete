package com.ah.towerfight.entities;

import java.util.ArrayList;
import java.util.List;

public class Reward {
    private List<RewardObject> rewardObjects;

    public Reward() {
        this.rewardObjects = new ArrayList<>();
    }

    public void ajouterRewardObject(RewardObject rewardObject) {
        rewardObjects.add(rewardObject);
    }

    public void retirerRewardObject(RewardObject rewardObject) {
        rewardObjects.remove(rewardObject);
    }

    public List<RewardObject> getRewardObjects() {
        return rewardObjects;
    }

    public void setRewardObjects(List<RewardObject> rewardObjects) {
        this.rewardObjects = rewardObjects;
    }
}
