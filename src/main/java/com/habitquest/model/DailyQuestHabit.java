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
        return 10; // flat rate placeholder, refine later with streak multiplier
    }

    @Override
    public void grantReward(User user) {
        // TODO: wire into LevelingSystem once it exists
        user.gainXP(calculateXPReward());
    }
}