package com.decathlon_competition.services.process.impl;

import com.decathlon_competition.domain.Athlete;
import com.decathlon_competition.services.process.Decider;

import java.util.Comparator;
import java.util.List;

public class DecathlonPlaceDecider implements Decider {

    @Override
    public void decidePlace(List<Athlete> list) {
        Comparator<Athlete> comparator = Comparator.comparingDouble(Athlete::getTotalPoints);
        list.sort(comparator.reversed().thenComparing(Athlete::getName));
        updatePlace(list);
    }

    private void updatePlace(List<Athlete> list) {
        int place = 1;
        int equalIndex;
        String palceDisplay;
        for(int top = 0;top < list.size();top++) {
            equalIndex = top;
            palceDisplay = String.valueOf(place);
            for(int lower = top + 1 ; lower < list.size();lower ++) {
                if(list.get(top).getTotalPoints() == list.get(lower).getTotalPoints()) {
                    palceDisplay = palceDisplay + "-" + (place + 1);
                    place ++;
                    equalIndex = lower;
                }
                else {
                    break;
                }
            }
            for(int i = top;i <= equalIndex;i++) {
                list.get(i).setPlace(palceDisplay);
            }

            place ++;
            top = equalIndex;
        }
    }
}
