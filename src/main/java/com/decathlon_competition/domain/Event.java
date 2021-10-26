package com.decathlon_competition.domain;

import com.decathlon_competition.enums.PointsSystemEnum;
import javax.xml.bind.annotation.XmlTransient;

public class Event {
    private String name;
    private double performance;
    private PointsSystemEnum points;

    public Event(String name, double performance) {
        this.name = name;
        this.performance = performance;
    }

    public Event(String name, double performance, PointsSystemEnum points) {
        this.name = name;
        this.performance = performance;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPerformance() {
        return performance;
    }

    public void setPerformance(double performance) {
        this.performance = performance;
    }

    @XmlTransient
    public PointsSystemEnum getPoints() {
        return points;
    }

    public void setPoints(PointsSystemEnum points) {
        this.points = points;
    }
}
