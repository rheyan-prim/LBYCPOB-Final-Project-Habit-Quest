package com.habitquest.controller;
import com.habitquest.repository.HabitRepository;
import com.habitquest.repository.UserRepository;
import com.habitquest.service.QuestManager;

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

}
