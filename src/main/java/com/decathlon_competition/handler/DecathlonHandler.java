package com.decathlon_competition.handler;

import com.decathlon_competition.domain.Athlete;
import com.decathlon_competition.exception.FileCreationException;
import com.decathlon_competition.services.process.Decider;
import com.decathlon_competition.services.process.PointsCalculator;
import com.decathlon_competition.services.reader.CSVFileReader;
import com.decathlon_competition.services.writer.FileWriter;

import java.io.IOException;
import java.util.List;

public class DecathlonHandler {

    private final CSVFileReader reader;
    private final FileWriter fileWriter;
    private final PointsCalculator pointsCalculator;
    private final Decider decider;

    public DecathlonHandler(CSVFileReader reader, FileWriter fileWriter, PointsCalculator pointsCalculator, Decider decider) {
        this.reader = reader;
        this.fileWriter = fileWriter;
        this.pointsCalculator = pointsCalculator;
        this.decider = decider;
    }

    public List<Athlete> process(String sourceFilePath, String destinationFilePath) throws IOException, FileCreationException {
        List<Athlete> recordList = reader.getRecordsFromFile(sourceFilePath);
        pointsCalculator.calculatePoints(recordList);
        decider.decidePlace(recordList);
        fileWriter.write(recordList, destinationFilePath);
        return recordList;
    }
}
