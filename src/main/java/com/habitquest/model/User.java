package com.habitquest.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password; // hashed later by Person 3's auth flow

    private int totalXP;
    private int currentLevel;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Habit> habits = new ArrayList<>();

    protected User() {
        // required by JPA
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.totalXP = 0;
        this.currentLevel = 1;
    }