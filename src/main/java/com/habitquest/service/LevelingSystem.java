package com.habitquest.service;

import org.springframework.stereotype.Component;

@Component
public class LevelingSystem {

    private static final int XP_PER_LEVEL = 100;

    public int calculateLevel(int totalXP) {
        return (totalXP / XP_PER_LEVEL) + 1;
    }

    public boolean hasLeveledUp(int oldXP, int newXP) {
        return calculateLevel(newXP) > calculateLevel(oldXP);
    }
}
