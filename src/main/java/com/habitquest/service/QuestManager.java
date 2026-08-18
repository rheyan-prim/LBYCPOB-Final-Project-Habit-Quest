package com.habitquest.service;

import com.habitquest.model.Habit;
import com.habitquest.model.Rewardable;
import com.habitquest.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class QuestManager {

    private final LevelingSystem levelingSystem;
    private final StreakTracker streakTracker;

    public QuestManager(LevelingSystem levelingSystem, StreakTracker streakTracker) {
        this.levelingSystem = levelingSystem;
        this.streakTracker = streakTracker;
    }

    public void completeHabit(User user, Habit habit) {
        habit.setCompletionStatus(true);

        LocalDate today = LocalDate.now();
        int updatedStreak = streakTracker.computeUpdatedStreak(
                habit.getLastCompletionDate(), today, habit.getStreakCount());
        habit.setStreakCount(updatedStreak);
        habit.setLastCompletionDate(today);

        double multiplier = streakTracker.getMultiplier(updatedStreak);

        if (habit instanceof Rewardable rewardable) {
            int oldXP = user.getTotalXP();
            rewardable.grantReward(user, multiplier);

            if (levelingSystem.hasLeveledUp(oldXP, user.getTotalXP())) {
                int newLevel = levelingSystem.calculateLevel(user.getTotalXP());
                user.setCurrentLevel(newLevel);
            }
        }
    }
}
