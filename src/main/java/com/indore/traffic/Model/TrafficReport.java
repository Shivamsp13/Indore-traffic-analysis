package com.indore.traffic.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TrafficReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private String level; // Low, Medium, High
    private String description;

    private LocalDateTime timestamp;

    // Constructor
    public TrafficReport() {
        this.timestamp = LocalDateTime.now();
    }

    public TrafficReport(String location, String level, String description) {
        this.location = location;
        this.level = level;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}