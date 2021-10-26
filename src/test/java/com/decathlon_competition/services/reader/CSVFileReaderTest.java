package com.decathlon_competition.services.reader;

import com.decathlon_competition.domain.Athlete;
import com.decathlon_competition.domain.Event;
import com.decathlon_competition.enums.PointsSystemEnum;
import com.decathlon_competition.services.reader.impl.CSVFileReaderImpl;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class CSVFileReaderTest {

    CSVFileReader reader = new CSVFileReaderImpl();

    @Test
    public void verifyIfReadAllEntries() throws IOException {

        List<Athlete> list = reader.getRecordsFromFile("src/test/resources/results.csv");
        assertEquals(4,list.size());
        assertTrue(list.stream().anyMatch(record -> record.getName().equals("John Smith")));
    }

    @Test
    public void checkEventOrder() throws IOException {
        List<Athlete> list = reader.getRecordsFromFile("src/test/resources/results.csv");
        Optional<Athlete> athlete = list.stream().filter(rec -> rec.getName().equals("John Smith")).findFirst();

        if(athlete.isPresent()) {
            List<Event> events = athlete.get().getEvents();
            assertEquals(10,events.size());

            for (Event event : events) {
                if(event.getPerformance() == 12.61) {
                    assertEquals(PointsSystemEnum.HM.getEventCode(),event.getName());
                }
                else if(event.getPerformance() == 500) {
                    assertEquals(PointsSystemEnum.LJ.getEventCode(),event.getName());
                }
                else if(event.getPerformance() == 9.22) {
                    assertEquals(PointsSystemEnum.SP.getEventCode(),event.getName());
                }
                else if(event.getPerformance() == 150) {
                    assertEquals(PointsSystemEnum.HJ.getEventCode(),event.getName());
                }
                else if(event.getPerformance() == 60.39) {
                    assertEquals(PointsSystemEnum.FM.getEventCode(),event.getName());
                }
                else if(event.getPerformance() == 16.43) {
                    assertEquals(PointsSystemEnum.HMH.getEventCode(),event.getName());
                }
                else if(event.getPerformance() == 21.60) {
                    assertEquals(PointsSystemEnum.DT.getEventCode(),event.getName());
                }
                else if(event.getPerformance() == 260) {
                    assertEquals(PointsSystemEnum.PV.getEventCode(),event.getName());
                }
                else if(event.getPerformance() == 35.81) {
                    assertEquals(PointsSystemEnum.JT.getEventCode(),event.getName());
                }
                else if(event.getPerformance() == 325.72) {
                    assertEquals(PointsSystemEnum.TFM.getEventCode(),event.getName());
                }
                else {
                    fail("Invalid input value");
                }
            }
        }
        else {
            fail("Required entry not available");
        }
    }

    @Test(expected = IOException.class)
    public void checkErrorIfGivenFileNotFound() throws IOException {
        CSVFileReader reader = new CSVFileReaderImpl();
        reader.getRecordsFromFile("src/test/resources/results_not_available.csv");
    }

    @Test(expected = NumberFormatException.class)
    public void checkErrorInvalidText() throws IOException {
        CSVFileReader reader = new CSVFileReaderImpl();
        reader.getRecordsFromFile("src/test/resources/results_with_invalid_entry.csv");
    }
}
