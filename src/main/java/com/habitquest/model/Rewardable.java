package com.habitquest.model;

public interface Rewardable {
    int calculateXPReward();
    void grantReward(User user);
}
