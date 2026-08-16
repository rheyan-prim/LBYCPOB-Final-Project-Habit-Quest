package com.habitquest.service;

import com.habitquest.model.Habit;
import com.habitquest.model.Rewardable;
import com.habitquest.model.User;
import org.springframework.stereotype.Component;

@Component
public class QuestManager {

    private final LevelingSystem levelingSystem;
    private final StreakTracker streakTracker;

    public QuestManager(LevelingSystem levelingSystem, StreakTracker streakTracker) {
        this.levelingSystem = levelingSystem;
        this.streakTracker = streakTracker;
    }

    public void completeHabit(User user, Habit habit) {
        habit.setCompletionStatus(true);

        if (habit instanceof Rewardable rewardable) {
            int oldXP = user.getTotalXP();
            rewardable.grantReward(user);

            if (levelingSystem.hasLeveledUp(oldXP, user.getTotalXP())) {
                int newLevel = levelingSystem.calculateLevel(user.getTotalXP());
                user.setCurrentLevel(newLevel);
            }
        }
    }
}
