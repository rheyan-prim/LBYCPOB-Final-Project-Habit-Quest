package com.habitquest.service;

import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class StreakTracker {
  
     /** Calculates the XP/Reward multiplier based on the current consecutive streak count.
     */
    public double getMultiplier(int streakCount) {
        if (streakCount >= 7) return 2.0;
        if (streakCount >= 3) return 1.5;
        return 1.0;
    }
