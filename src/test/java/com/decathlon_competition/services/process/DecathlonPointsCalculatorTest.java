package com.decathlon_competition.services.process;

import com.decathlon_competition.domain.Athlete;
import com.decathlon_competition.domain.Event;
import com.decathlon_competition.enums.PointsSystemEnum;
import com.decathlon_competition.services.process.impl.DecathlonPointsCalculator;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
public class DecathlonPointsCalculatorTest {

    @Test
    public void checkTotalPoints(){
        Athlete athlete = new Athlete();
        athlete.setName("TestUser");
        athlete.setEvents(getEvents());
        List<Athlete> list = new ArrayList<>();
        list.add(athlete);
        new DecathlonPointsCalculator().calculatePoints(list);
        assertEquals(9131, (int) list.get(0).getTotalPoints());
    }

    @Test
    public void checkPointsForTrackEvent(){
        List<Event> events = new ArrayList<>();
        events.add(new Event(PointsSystemEnum.HM.getEventCode(), 10.55,PointsSystemEnum.HM));
        Athlete athlete = new Athlete();
        athlete.setName("TestUser");
        athlete.setEvents(events);
        List<Athlete> list = new ArrayList<>();
        list.add(athlete);
        new DecathlonPointsCalculator().calculatePoints(list);
        assertEquals(963, (int) list.get(0).getTotalPoints());
    }

    @Test
    public void checkPointsForFieldEvent(){
        List<Event> events = new ArrayList<>();
        events.add(new Event(PointsSystemEnum.HJ.getEventCode(), 205,PointsSystemEnum.HJ));
        Athlete athlete = new Athlete();
        athlete.setName("TestUser");
        athlete.setEvents(events);
        List<Athlete> list = new ArrayList<>();
        list.add(athlete);
        new DecathlonPointsCalculator().calculatePoints(list);
        assertEquals(850, (int) list.get(0).getTotalPoints());
    }

    @Test (expected = NumberFormatException.class)
    public void checkErrorForInvalidNumber(){
        List<Event> events = new ArrayList<>();
        events.add(new Event(PointsSystemEnum.HJ.getEventCode(), -205,PointsSystemEnum.HJ));
        Athlete athlete = new Athlete();
        athlete.setEvents(events);
        List<Athlete> list = new ArrayList<>();
        list.add(athlete);
        new DecathlonPointsCalculator().calculatePoints(list);
    }

    private List<Event> getEvents() {
        List<Event> events = new ArrayList<>();
        events.add(new Event(PointsSystemEnum.HM.getEventCode(), 10.55,PointsSystemEnum.HM));
        events.add(new Event(PointsSystemEnum.LJ.getEventCode(), 780,PointsSystemEnum.LJ));
        events.add(new Event(PointsSystemEnum.SP.getEventCode(), 16,PointsSystemEnum.SP));
        events.add(new Event(PointsSystemEnum.HJ.getEventCode(), 205,PointsSystemEnum.HJ));
        events.add(new Event(PointsSystemEnum.FM.getEventCode(), 48.42,PointsSystemEnum.FM));
        events.add(new Event(PointsSystemEnum.HMH.getEventCode(), 13.75,PointsSystemEnum.HMH));
        events.add(new Event(PointsSystemEnum.DT.getEventCode(), 50.54,PointsSystemEnum.DT));
        events.add(new Event(PointsSystemEnum.PV.getEventCode(), 545,PointsSystemEnum.PV));
        events.add(new Event(PointsSystemEnum.JT.getEventCode(), 71.9,PointsSystemEnum.JT));
        events.add(new Event(PointsSystemEnum.TFM.getEventCode(), 276,PointsSystemEnum.TFM));
        return events;
    }
}
