package com.habitquest.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DAILY")
public class DailyQuestHabit extends Habit implements Rewardable {

    protected DailyQuestHabit() {
        super();
    }

    public DailyQuestHabit(String title, String description, String imagePath) {
        super(title, description, imagePath);
    }

    @Override
    public int calculateXPReward() {
        return 10; // flat rate
    }

    @Override
    public void grantReward(User user, double multiplier) {
        int finalXP = (int) Math.round(calculateXPReward() * multiplier);
        user.gainXP(calculateXPReward());
    }

}