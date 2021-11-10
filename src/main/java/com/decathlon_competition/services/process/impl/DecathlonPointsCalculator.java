package com.decathlon_competition.services.process.impl;

import com.decathlon_competition.domain.Athlete;
import com.decathlon_competition.domain.Event;
import com.decathlon_competition.enums.PointsSystemEnum;
import com.decathlon_competition.enums.TypeOfMeasureEnum;
import com.decathlon_competition.services.process.FieldEventCalculator;
import com.decathlon_competition.services.process.PointsCalculator;
import com.decathlon_competition.services.process.TrackEventCalculator;

import java.util.List;

public class DecathlonPointsCalculator implements PointsCalculator {

    @Override
    public void calculatePoints(List<Athlete> list) {
        list.forEach(record ->
                record.setTotalPoints(getTotalPoints(record.getEvents())));
    }

    private double getTotalPoints(List<Event> events) {
        double total = 0;
        for (Event event : events) {
            PointsSystemEnum eventPoints = event.getPoints();
            total = total + getEventTotal(eventPoints, event.getPerformance());
        }
        return total;
    }

    private double getEventTotal(PointsSystemEnum eventPoints, double performance) {
        if (eventPoints.getUnitOfMeasure() == TypeOfMeasureEnum.TIME)
            return TrackEventCalculator.calculate(eventPoints.getA(),eventPoints.getB(),eventPoints.getC(),performance);
        else
            return FieldEventCalculator.calculate(eventPoints.getA(),eventPoints.getB(),eventPoints.getC(),performance);
    }
}
