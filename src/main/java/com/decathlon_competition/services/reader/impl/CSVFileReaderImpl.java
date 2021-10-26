package com.decathlon_competition.services.reader.impl;

import com.decathlon_competition.domain.Athlete;
import com.decathlon_competition.domain.Event;
import com.decathlon_competition.enums.PointsSystemEnum;
import com.decathlon_competition.services.reader.CSVFileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReaderImpl implements CSVFileReader {

    private final String SPLITTER = ";";

    @Override
    public List<Athlete> getRecordsFromFile(String path) throws IOException, NumberFormatException {
        String line;
        List<Athlete> athletes = new ArrayList<>();
        System.out.println("Read file from " + path);
        BufferedReader br = new BufferedReader(new FileReader(path));
        while ((line = br.readLine()) != null) {
            String[] athleteEntry = line.split(SPLITTER);
            athletes.add(getAthlete(athleteEntry));
        }
        return athletes;
    }

    private Athlete getAthlete(String[] athleteEntry) throws IOException, NumberFormatException {
        Athlete athlete = new Athlete();
        athlete.setName(athleteEntry[0]);
        List<Event> eventList = new ArrayList<>();
        for (int i = 1; i <= athleteEntry.length - 1; i++) {
            double value = getConvertedValue(athleteEntry[i], getPointsSystem(i));
            eventList.add(new Event(getPointsSystem(i).getEventCode(), value, getPointsSystem(i)));
        }
        athlete.setEvents(eventList);
        return athlete;
    }

    private PointsSystemEnum getPointsSystem(int order) throws IOException {
        switch (order) {
            case 1:
                return PointsSystemEnum.HM;
            case 2:
                return PointsSystemEnum.LJ;
            case 3:
                return PointsSystemEnum.SP;
            case 4:
                return PointsSystemEnum.HJ;
            case 5:
                return PointsSystemEnum.FM;
            case 6:
                return PointsSystemEnum.HMH;
            case 7:
                return PointsSystemEnum.DT;
            case 8:
                return PointsSystemEnum.PV;
            case 9:
                return PointsSystemEnum.JT;
            case 10:
                return PointsSystemEnum.TFM;
            default:
                throw new IOException("");
        }
    }

    private double getConvertedValue(String value, PointsSystemEnum pointSystem) throws NumberFormatException {
        switch (pointSystem) {
            case LJ:
            case HJ:
            case PV:
                return Double.parseDouble(value) * 100;
            case TFM:
                return getSecondsFromMinutes(value);
            default:
                return Double.parseDouble(value);
        }
    }

    private double getSecondsFromMinutes(String value) throws NumberFormatException {
        String[] splitStr = value.split(":");
        return Double.parseDouble(splitStr[0]) * 60 + Double.parseDouble(splitStr[1]);
    }

}
