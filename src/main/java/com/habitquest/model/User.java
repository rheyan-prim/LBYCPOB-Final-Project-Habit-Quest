package com.habitquest.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Habit> habits = new ArrayList<>();

    public List<Habit> getHabits() {
        return habits;
    }

    public void setHabits(List<Habit> habits) {
        this.habits = habits;
    }
    
    public void addHabit(Habit habit) {
        if (this.habits == null) {
            this.habits = new ArrayList<>();
        }
        this.habits.add(habit);
    }

    public void gainXP(int xp) {
        if (xp <= 0) return;
        this.totalXP += xp;

        // Example level up logic: level increases for every 100 total XP
        this.currentLevel = (this.totalXP / 100) + 1;
    }

    private int currentLevel = 1;
    private int totalXP = 0; 

    // Default No-Args Constructor (Required by JPA)
    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.currentLevel = 1;
        this.totalXP = 0;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public int getCurrentLevel() { return currentLevel; }
    public void setCurrentLevel(int currentLevel) { this.currentLevel = currentLevel; }

    public int getTotalXP() { return totalXP; }
    public void setTotalXP(int totalXP) { this.totalXP = totalXP; }
}
