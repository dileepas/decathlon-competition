package com.decathlon_competition.services.reader;

import com.decathlon_competition.domain.Athlete;

import java.io.IOException;
import java.util.List;

public interface CSVFileReader {
    /**
     *
     * @param path provided
     * @return
     * @throws IOException
     * @throws NumberFormatException
     */
    List<Athlete> getRecordsFromFile(String path) throws IOException, NumberFormatException;
}
