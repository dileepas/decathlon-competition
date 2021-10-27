package com.decathlon_competition.services.writer;

import com.decathlon_competition.domain.Athlete;
import com.decathlon_competition.domain.DecathlonCompetition;
import com.decathlon_competition.exception.FileCreationException;

import java.util.List;

public interface FileWriter {
    /**
     * This method is responsible to write the given list of records into a desired file format and save in the given file path.
     * @param athletes
     * @param filePath
     * @return Type that is used to create the output file.
     * @throws FileCreationException
     */
    DecathlonCompetition write(List<Athlete> athletes, String filePath) throws FileCreationException;
}
