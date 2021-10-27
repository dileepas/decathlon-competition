package com.decathlon_competition.services.reader;

import com.decathlon_competition.domain.Athlete;

import java.io.IOException;
import java.util.List;

public interface CSVFileReader {
    /**
     * This Method is responsible to read the file from provided path and extract list of athletes and record.
     * @param path provided
     * @return  List of Athletes and their records
     * @throws IOException
     * @throws NumberFormatException
     */
    List<Athlete> getRecordsFromFile(String path) throws IOException, NumberFormatException;
}
