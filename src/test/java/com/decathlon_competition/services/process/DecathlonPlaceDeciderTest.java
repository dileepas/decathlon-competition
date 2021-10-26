package com.decathlon_competition.services.process;

import com.decathlon_competition.domain.Athlete;
import com.decathlon_competition.services.process.impl.DecathlonPlaceDecider;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class DecathlonPlaceDeciderTest {

    Decider placeDecider = new DecathlonPlaceDecider();

    @Test
    public void testPlaceWithDifferentTotalPoints(){
        Athlete athlete1 = new Athlete();
        athlete1.setName("Athlete1");
        athlete1.setTotalPoints(1500.58);
        Athlete athlete2 = new Athlete();
        athlete2.setName("Athlete2");
        athlete2.setTotalPoints(3200.6);
        Athlete athlete3 = new Athlete();
        athlete3.setName("Athlete3");
        athlete3.setTotalPoints(1400);

        List<Athlete> list = new ArrayList<>();
        list.add(athlete1);
        list.add(athlete2);
        list.add(athlete3);

        placeDecider.decidePlace(list);

        Athlete top = list.get(0);
        assertEquals("Athlete2",top.getName());
        assertEquals("1",top.getPlace());

        Athlete second = list.get(1);
        assertEquals("Athlete1",second.getName());
        assertEquals("2",second.getPlace());

        Athlete last = list.get(2);
        assertEquals("Athlete3",last.getName());
        assertEquals("3",last.getPlace());
    }

    @Test
    public void testPlaceWhenTwoWithSamePoint(){
        Athlete athlete1 = new Athlete();
        athlete1.setName("Athlete1");
        athlete1.setTotalPoints(1500.58);
        Athlete athlete2 = new Athlete();
        athlete2.setName("Athlete2");
        athlete2.setTotalPoints(3200.6);
        Athlete athlete3 = new Athlete();
        athlete3.setName("Athlete3");
        athlete3.setTotalPoints(1500.58);

        List<Athlete> list = new ArrayList<>();
        list.add(athlete1);
        list.add(athlete2);
        list.add(athlete3);

        placeDecider.decidePlace(list);

        Athlete top = list.get(0);
        assertEquals("Athlete2",top.getName());
        assertEquals("1",top.getPlace());

        Athlete second = list.get(1);
        assertEquals("Athlete1",second.getName());
        assertEquals("2-3",second.getPlace());

        Athlete last = list.get(2);
        assertEquals("Athlete3",last.getName());
        assertEquals("2-3",last.getPlace());
    }

    @Test
    public void testOrderWithNameWhenPointsAreSame(){
        Athlete athlete1 = new Athlete();
        athlete1.setName("Xyz");
        athlete1.setTotalPoints(3200.6);
        Athlete athlete2 = new Athlete();
        athlete2.setName("Abc");
        athlete2.setTotalPoints(3200.6);
        Athlete athlete3 = new Athlete();
        athlete3.setName("Acd");
        athlete3.setTotalPoints(3200.6);

        List<Athlete> list = new ArrayList<>();
        list.add(athlete1);
        list.add(athlete2);
        list.add(athlete3);

        placeDecider.decidePlace(list);

        Athlete top = list.get(0);
        assertEquals("Abc",top.getName());
        assertEquals("1-2-3",top.getPlace());

        Athlete second = list.get(1);
        assertEquals("Acd",second.getName());
        assertEquals("1-2-3",second.getPlace());

        Athlete last = list.get(2);
        assertEquals("Xyz",last.getName());
        assertEquals("1-2-3",last.getPlace());
    }
}
