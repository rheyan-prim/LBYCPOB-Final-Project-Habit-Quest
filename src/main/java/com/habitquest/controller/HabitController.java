package com.habitquest.controller;
import com.habitquest.model.Habit;
import com.habitquest.model.User;
import com.habitquest.repository.HabitRepository;
import com.habitquest.repository.UserRepository;
import com.habitquest.service.QuestManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class HabitController {
    private final HabitRepository habitRepository;
    private final UserRepository userRepository;
    private final QuestManager questManager;

    public HabitController(HabitRepository habitRepository, UserRepository userRepository, QuestManager questManager) {
        this.habitRepository = habitRepository;
        this.userRepository = userRepository;
        this.questManager = questManager;
    }

    // Fetch all habits for a specific user
    @GetMapping
    public List<Habit> getUserHabits(@RequestParam Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getHabits();
    }

}
