package com.decathlon_competition.services.process;

import com.decathlon_competition.domain.Athlete;

import java.util.List;

public interface Decider {
    /**
     * This method set the place of an athlete in the given list.
     * @param list
     */
    void decidePlace(List<Athlete> list);
}
