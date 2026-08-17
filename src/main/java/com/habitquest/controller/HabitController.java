package com.habitquest.controller;
import com.habitquest.model.DailyQuestHabit;
import com.habitquest.model.Habit;
import com.habitquest.model.ToDoQuestHabit;
import com.habitquest.model.User;
import com.habitquest.repository.HabitRepository;
import com.habitquest.repository.UserRepository;
import com.habitquest.service.QuestManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    // Create a recurring Daily Quest habit
    @PostMapping("/daily")
    public Habit createDailyHabit(@RequestParam Long userId,
                                  @RequestParam String title,
                                  @RequestParam String description,
                                  @RequestParam(defaultValue = "") String imagePath) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        DailyQuestHabit habit = new DailyQuestHabit(title, description, imagePath);
        Habit savedHabit = habitRepository.save(habit);

        user.getHabits().add(savedHabit);
        userRepository.save(user);

        return savedHabit;
    }

    // Create a one-time To-Do habit
    @PostMapping("/todo")
    public Habit createToDoHabit(@RequestParam Long userId,
                                 @RequestParam String title,
                                 @RequestParam String description,
                                 @RequestParam(defaultValue = "") String imagePath) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ToDoQuestHabit habit = new ToDoQuestHabit(title, description, imagePath);
        Habit savedHabit = habitRepository.save(habit);

        user.getHabits().add(savedHabit);
        userRepository.save(user);

        return savedHabit;
    }

}
