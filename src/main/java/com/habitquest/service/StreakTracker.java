package com.habitquest.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class StreakTracker {
  
     /** Calculates the XP/Reward multiplier based on the current consecutive streak count.
     */
    public double getMultiplier(int streakCount) {
        if (streakCount >= 7) return 2.0;
        if (streakCount >= 3) return 1.5;
        return 1.0;
    }

    public int computeUpdatedStreak(LocalDate lastCompletionDate, LocalDate today, int currentStreak) {
        // First completion ever
        if (lastCompletionDate == null) {
            return 1;
        }
        // Already logged today — keep streak unchanged
        if (lastCompletionDate.equals(today)) {
            return currentStreak;
        }
        // Logged yesterday — increment streak
        if (lastCompletionDate.equals(today.minusDays(1))) {
            return currentStreak + 1;
        }
        // Missed one or more days — streak broken, reset to 1
        return 1;
    }
}
