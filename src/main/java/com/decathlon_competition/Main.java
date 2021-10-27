package com.decathlon_competition;

import com.decathlon_competition.exception.FileCreationException;
import com.decathlon_competition.handler.DecathlonHandler;
import com.decathlon_competition.services.process.impl.DecathlonPlaceDecider;
import com.decathlon_competition.services.process.impl.DecathlonPointsCalculator;
import com.decathlon_competition.services.process.Decider;
import com.decathlon_competition.services.process.PointsCalculator;
import com.decathlon_competition.services.reader.CSVFileReader;
import com.decathlon_competition.services.reader.impl.CSVFileReaderImpl;
import com.decathlon_competition.services.writer.FileWriter;
import com.decathlon_competition.services.writer.impl.XMLFileWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CSVFileReader reader = new CSVFileReaderImpl();
        FileWriter fileWriter = new XMLFileWriter();
        PointsCalculator pointsCalculator = new DecathlonPointsCalculator();
        Decider decider = new DecathlonPlaceDecider();

        String sourceFilePath = "src/main/resources/results.csv";
        String destinationFilePath = "decathlon-result.xml";

        DecathlonHandler handler = new DecathlonHandler(reader, fileWriter, pointsCalculator, decider);

        try {
            System.out.println("---------Start-------");
            handler.process(sourceFilePath, destinationFilePath);
            System.out.println("---------End-------");
        } catch (IOException | FileCreationException e) {
            e.printStackTrace();
        }
    }
}
