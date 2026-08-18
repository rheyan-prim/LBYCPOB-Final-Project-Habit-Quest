package com.habitquest.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "habit_type")
public abstract class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String imagePath;
    private boolean completionStatus;
    private LocalDate lastCompletionDate;
    private int streakCount;

    protected Habit() {

    }

    public Habit(String title, String description, String imagePath) {
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;
        this.completionStatus = false;
        this.streakCount = 0;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }

    public LocalDate getLastCompletionDate() {
        return lastCompletionDate;
    }

    public void setLastCompletionDate(LocalDate lastCompletionDate) {
        this.lastCompletionDate = lastCompletionDate;
    }

    public int getStreakCount() {
        return streakCount;
    }

    // ADDED: Missing setter required by StreakTracker / services to update streaks
    public void setStreakCount(int streakCount) {
        this.streakCount = streakCount;
    }
}
