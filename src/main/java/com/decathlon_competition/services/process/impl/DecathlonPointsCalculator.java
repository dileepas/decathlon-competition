package com.decathlon_competition.services.process.impl;

import com.decathlon_competition.domain.Athlete;
import com.decathlon_competition.domain.Event;
import com.decathlon_competition.enums.PointsSystemEnum;
import com.decathlon_competition.enums.TypeOfMeasureEnum;
import com.decathlon_competition.services.process.EventCalculator;
import com.decathlon_competition.services.process.PointsCalculator;

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
            total = total + getEventCalculator(eventPoints.getUnitOfMeasure()).calculate(
                    eventPoints.getA(),
                    eventPoints.getB(),
                    eventPoints.getC(),
                    event.getPerformance());
        }
        return total;
    }

    private EventCalculator getEventCalculator(TypeOfMeasureEnum typeOfMeasureEnum) {
        if (typeOfMeasureEnum == TypeOfMeasureEnum.TIME)
            return new TrackEventCalculator();
        else
            return new FieldEventCalculator();
    }
}
