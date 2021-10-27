package com.decathlon_competition.services.process;

import com.decathlon_competition.domain.Athlete;
import java.util.List;

public interface PointsCalculator {
    /**
     * This method is responsible to set the total points of an athlete according to the performance of the events.
     * @param list
     */
    void calculatePoints(List<Athlete> list);
}
