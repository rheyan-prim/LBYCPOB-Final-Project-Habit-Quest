package com.habitquest.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    private int totalXP;
    private int currentLevel;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Habit> habits = new ArrayList<>();

    public List<Habit> getHabits() {
        return habits;
    }
    
    protected User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.totalXP = 0;
        this.currentLevel = 1;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getTotalXP() {
        return totalXP;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public List<Habit> getHabits() {
        return habits;
    }

    public void addHabit(Habit habit) {
        habits.add(habit);
    }

    // encapsulated: XP can only change through this method, not directly
    public void gainXP(int amount) {
        this.totalXP += amount;
        //QuestManager orchestrates the level calculation via LevelingSystem
    }

    public void setCurrentLevel(int currentLevel) {
    this.currentLevel = currentLevel;
}
}
