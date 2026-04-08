package com.indore.traffic.Model;

import jakarta.persistence.*;

@Entity
public class TrafficZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String area;
    private String peakTime;
    private String cause;

    public TrafficZone() {}

    public TrafficZone(String name, String area, String peakTime, String cause) {
        this.name = name;
        this.area = area;
        this.peakTime = peakTime;
        this.cause = cause;
    }

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getPeakTime() { return peakTime; }
    public void setPeakTime(String peakTime) { this.peakTime = peakTime; }

    public String getCause() { return cause; }
    public void setCause(String cause) { this.cause = cause; }
}