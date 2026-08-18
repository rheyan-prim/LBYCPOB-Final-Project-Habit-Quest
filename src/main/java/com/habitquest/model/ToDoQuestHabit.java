package com.habitquest.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TODO")
public class ToDoQuestHabit extends Habit implements Rewardable {

    protected ToDoQuestHabit() {
        super();
    }

    public ToDoQuestHabit(String title, String description, String imagePath) {
        super(title, description, imagePath);
    }

    @Override
    public int calculateXPReward() {
        return 50; // one-time "epic quest", higher than daily
    }

    @Override
    public void grantReward(User user, double multiplier) {
        int finalXP = (int) Math.round(calculateXPReward() * multiplier);
        user.gainXP(finalXP);
    }
}