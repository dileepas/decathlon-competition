package com.decathlon_competition.services.process;

import com.decathlon_competition.domain.Athlete;

import java.util.List;

public interface Decider {
    void decidePlace(List<Athlete> list);
}
